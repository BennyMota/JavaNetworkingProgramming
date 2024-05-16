//package com.benza;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Robot {
//    private String name;
//
//    private List<Robot> robots;
//
//    public Robot() {
//        this.robots = new ArrayList<>();
//    }
//
//    public Robot(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    // Implement the getObjectsInSight() method
//    public List<Object> getObjectsInSight() {
//        // I'm gonna return a list of objects in the robot's line of sight
//        // For simplicity, I'll be returning an empty list
//        return new ArrayList<>();
//    }
//
//    public Robot getRobotByName(String name) {
//        for (Robot robot : robots) {
//            if (robot.getName().equals(name)) {
//                return robot;
//            }
//        }
//        return null;
//    }
//}
