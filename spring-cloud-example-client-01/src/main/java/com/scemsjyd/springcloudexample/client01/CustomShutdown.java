package com.scemsjyd.springcloudexample.client01;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.omg.CORBA.TIMEOUT;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CustomShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {

    private Connector connector;

    @Override
    public void customize(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        // 暂停接收外部请求
        this.connector.pause();

        // 关闭连接的请求
        Executor executor = this.connector.getProtocolHandler().getExecutor();
        if (executor instanceof ThreadPoolExecutor) {
            try {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                threadPoolExecutor.shutdown();
                if (!threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                    threadPoolExecutor.shutdownNow();
                    log.warn("应用超时关闭");
                    if (!threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                        log.error("应用关闭失败");
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
