//package com.benza;
//
//import java.util.List;
//
//public class lookCommand extends Command {
//    public void lookCommand(String robotName) {
//
//    }
//
//    @Override
//    public boolean execute(Robot target) {
//        Robot robot = robot.getRobotByName(robotName);
//        if (robot != null) {
//            System.out.println("Robot " + robotName + " can see:");
//            // Implement the logic to get all objects in the robot's line of sight
//            // For simplicity, let's assume we have a method getObjectsInSight() in the Robot class
//            List<Object> objectsInSight = robot.getObjectsInSight();
//            for (Object obj : objectsInSight) {
//                System.out.println(obj.toString());
//            }
//        } else {
//            System.out.println("Robot " + robotName + " not found.");
//        }
//        return false;
//    }
//}
