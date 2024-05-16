//package com.benza;
//
//public abstract class Command {
//
//    private final String name;
//    private String argument;
//
//    protected Command(String name) {
//        this.name = name.trim().toLowerCase();
//    }
//
//    public abstract boolean execute(Robot target);
//
//    public String getName() {                                                                           //<2>
//        return name;
//    }
//
//    public static lookCommand create(String instruction) {
//        String[] args = instruction.toLowerCase().trim().split(" ");
//        switch (args[0]) {
//            case "look":
//                return new lookCommand();
//        }
//        return null;
//    }
//}
