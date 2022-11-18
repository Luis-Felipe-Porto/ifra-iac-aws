package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ecs.Cluster;
import software.amazon.awscdk.services.ecs.ContainerImage;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateService;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedTaskImageOptions;
import software.constructs.Construct;


public class AwsServiceEadStack extends Stack {
    public AwsServiceEadStack(final Construct scope, final String id, final Cluster cluster) {
        this(scope, id, null,cluster);
    }

    public AwsServiceEadStack(final Construct scope, final String id, final StackProps props,final Cluster cluster) {
        super(scope, id, props);

        ApplicationLoadBalancedFargateService.Builder.create(this, "EadService")
                .serviceName("ead-microsservice")
                .cluster(cluster)
                .cpu(512)
                .desiredCount(1)
                .listenerPort(8080)
                .assignPublicIp(true)
                .taskImageOptions(
                        ApplicationLoadBalancedTaskImageOptions.builder()
                                .image(ContainerImage.fromRegistry("jacquelineoliveira/ola:1.0"))//imagem da nossa aplicação
                                .containerPort(8080)
                                .containerName("app_ola")
                                .build())
                .memoryLimitMiB(1024)
                .publicLoadBalancer(true)
                .build();

    }
}
