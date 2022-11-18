package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class AwsInfraEadApp {
    public static void main(final String[] args) {
        App app = new App();
        AwsInfraVpcStack vpcStack = new AwsInfraVpcStack(app, "Vpc");
        AwsClusterEadStack clusterStack = new AwsClusterEadStack(app, "cluster", vpcStack.getVpc());
        /*Usar o vpc como dependencia do cluster na criação*/
        clusterStack.addDependency(vpcStack);
        AwsServiceEadStack awsServiceEadStack=  new AwsServiceEadStack(app,"Service",clusterStack.getCluster());
        /*Usar o cluster como dependencia do service na criação*/
        awsServiceEadStack.addDependency(clusterStack);

        app.synth();
    }
}

