package com.yq;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.yq.context.IoTContext;
import com.yq.ruleActor.HelloActor;

import java.io.IOException;


public class AkkaAlarmActorExceptionDemo {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("AlarmDemo");
        try {
            IoTContext ioTContext = new IoTContext();

            final ActorRef helloActor =
                    system.actorOf(HelloActor.props(ioTContext), "helloActor");

            helloActor.tell("hello", ActorRef.noSender());

            helloActor.tell("exception", ActorRef.noSender());
            helloActor.tell("other Message", ActorRef.noSender());
            helloActor.tell("hello2", ActorRef.noSender());



            System.out.println(">>> Press ENTER to exit <<<");
            System.in.read();
        } catch (IOException ioe) {
        } finally {
            system.terminate();
        }
    }
}
