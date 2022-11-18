package com.myorg;

import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;


public class AwsInfraEadStack extends Stack {
    public AwsInfraEadStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public AwsInfraEadStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here

        // example resource
        // final Queue queue = Queue.Builder.create(this, "AwsInfraEadQueue")
        //         .visibilityTimeout(Duration.seconds(300))
        //         .build();
    }
}
