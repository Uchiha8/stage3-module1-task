package com.mjc.school;

import com.mjc.school.controller.NewsController;
import com.mjc.school.service.dto.NewsDTO;

import java.util.Scanner;

public class Main {

    private static NewsController newsController = new NewsController();

    public static void main(String[] args) {
        action();
    }

    public static void action() {
        boolean status = true;
        while (status) {
            listOfFunctions();
            Scanner scanner = new Scanner(System.in);
            int numOfFunction = scanner.nextInt();
            switch (numOfFunction) {
                case 1: {
                    System.out.println("=====List of News=====");
                    newsController.getAllNews();
                    break;
                }
                case 2: {
                    System.out.print("Enter ID: ");
                    Long id = scanner.nextLong();
                    newsController.getNewsById(id);
                    break;
                }
                case 3: {
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter content: ");
                    String content = scanner.nextLine();
                    System.out.println("Enter author ID: ");
                    Long authorID = scanner.nextLong();
                    NewsDTO newsDTO = new NewsDTO(title, content, authorID);
                    newsController.create(newsDTO);
                    break;
                }
                case 4: {
                    System.out.print("Enter News ID: ");
                    Long id = scanner.nextLong();
                    System.out.print("Enter updated title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter updated content: ");
                    String content = scanner.nextLine();
                    System.out.print("Enter updated author ID: ");
                    Long authorID = scanner.nextLong();
                    NewsDTO newsDTO = new NewsDTO(title, content, authorID);
                    newsController.updateNewsById(newsDTO);
                    break;
                }
                case 5: {
                    System.out.print("Enter Deleted News ID: ");
                    Long id = scanner.nextLong();
                    newsController.deleteNewsById(id);
                    break;
                }
                case 6: {
                    status = false;
                }
                default:
                    System.out.println("Are you crazy.... :)");
            }
        }
    }

    public static void listOfFunctions() {
        System.out.println("Hello select your prefered function\n" +
                "1 -> Get All News\n" +
                "2 -> Get News by id\n" +
                "3 -> Create News by id\n" +
                "4 -> Update news by id\n" +
                "5 -> Delete news by id\n" +
                "6 -> Exit");

    }
}