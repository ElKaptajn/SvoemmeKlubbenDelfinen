package com.company;

import java.io.*;
import java.util.*;

/**
 * @author Xenius
 * @author Thomas
 * @author Philip
 */

public class Result {

    public void resultMenu(Scanner input, ArrayList<Member> members, ArrayList<CompetitionMember> competitionMembers) throws IOException {
        MemberHandler memberHandler = new MemberHandler();
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    ┌───────────────────────── result menu ─────────────────────────┐
                    │ Enter 0 to exit result menu                                   │
                    │ Enter 1 to show the top five lists                            │
                    │ Enter 2 to add a new result                                   │
                    │ Enter 3 to edit an existing result                            │
                    │ Enter 4 to make an existing member into a competition Member  │
                    │ Enter 5 to show all competition members                       │
                    │ Enter 6 to show all results                                   │
                    └───────────────────────────────────────────────────────────────┘""");
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    topFiveTeamType(competitionMembers, input);
                    break;
                case 2:
                    addResult(input, competitionMembers);
                    writeToCompetitionMemberList(competitionMembers);
                    break;
                case 3:
                    editResult(input, competitionMembers);
                    writeToCompetitionMemberList(competitionMembers);
                    break;
                case 4:
                    makeMemberToCompetitionMember(input, members, competitionMembers);
                    writeToCompetitionMemberList(competitionMembers);
                    memberHandler.writeToMemberFile(members);
                    break;
                case 5:
                    showSpecificCompetitionMember(input, competitionMembers);
                    break;
                case 6:
                    break;
                default:
                    if (answer == 0) {
                        break;
                    } else {
                        System.out.println("Number " + answer + " is not a valid option");
                    }
            }
        }
    }

    public void addResult(Scanner input, ArrayList<CompetitionMember> competitionMembers) {
        System.out.println("┌────────────────────────────── Competition Members ──────────────────────────────┐");
        showCompetitionMembers(competitionMembers);
        System.out.println("│                                 Enter 0 to exit                                 │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘\n");
        System.out.println("Enter the number of the member you want to add a result to: ");
        int answerMember = input.nextInt();
        CompetitionMember competitionMember = competitionMembers.get(answerMember - 1);
        System.out.println("""
                    ┌─ Which Swimming discipline do you want to add a new time to? ─┐
                    │ Type 1 for Crawl                                              │
                    │ Type 2 for Breaststroke                                       │
                    │ Type 3 for Butterfly                                          │
                    │ Type 4 for Backstroke                                         │
                    └───────────────────────────────────────────────────────────────┘""");
        String stringAnswer;
        boolean timeTestAnswer;
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                System.out.print("New best time for Crawl (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                timeTestAnswer = timeTester(competitionMember.trainingResult[0], stringAnswer);
                if (!timeTestAnswer) {
                    System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[0]);
                } else {
                    competitionMember.trainingResult[0] = stringAnswer;
                    System.out.print("\nDate that the new record was set: ");
                    stringAnswer = input.next();
                    competitionMember.date[0] = stringAnswer;
                }
                break;
            case 2:
                System.out.print("New best time for Breaststroke (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                timeTestAnswer = timeTester(competitionMember.trainingResult[1], stringAnswer);
                if (!timeTestAnswer) {
                    System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[1]);
                } else {
                    competitionMember.trainingResult[1] = stringAnswer;
                    System.out.print("\nDate that the new record was set: ");
                    stringAnswer = input.next();
                    competitionMember.date[1] = stringAnswer;
                }
                break;
            case 3:
                System.out.print("New best time for Butterfly (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                timeTestAnswer = timeTester(competitionMember.trainingResult[2], stringAnswer);
                if (!timeTestAnswer) {
                    System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[2]);
                } else {
                    competitionMember.trainingResult[2] = stringAnswer;
                    System.out.print("\nDate that the new record was set: ");
                    stringAnswer = input.next();
                    competitionMember.date[2] = stringAnswer;
                }
                break;
            case 4:
                System.out.print("New best time for Backstroke (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                timeTestAnswer = timeTester(competitionMember.trainingResult[3], stringAnswer);
                if (!timeTestAnswer) {
                    System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[3]);
                } else {
                    competitionMember.trainingResult[3] = stringAnswer;
                    System.out.print("\nDate that the new record was set: ");
                    stringAnswer = input.next();
                    competitionMember.date[3] = stringAnswer;
                }
                break;
            default:
                System.out.println("The number " + answer + " is not a valid option");
        }
    }

    public void editResult(Scanner input, ArrayList<CompetitionMember> competitionMembers) {
        System.out.println("┌────────────────────────────── Competition Members ──────────────────────────────┐");
        showCompetitionMembers(competitionMembers);
        System.out.println("│                                 Enter 0 to exit                                 │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘\n");
        System.out.println("Enter the number of the member you want to edit a result from: ");
        int answerMember = input.nextInt();
        CompetitionMember competitionMember = competitionMembers.get(answerMember - 1);
        System.out.println("""
                ┌─ Which Swimming discipline do you want to add a new time to? ─┐
                │ Type 1 for Crawl                                              │
                │ Type 2 for Breaststroke                                       │
                │ Type 3 for Butterfly                                          │
                │ Type 4 for Backstroke                                         │
                └───────────────────────────────────────────────────────────────┘""");
        String stringAnswer;
        int answer = input.nextInt();
        if (answer >= 1 && answer <= 3) {
            System.out.print("New best time for " + competitionMember.disciplinType[answer - 1] + "(MUST be written in this format: xx:xx): ");
            stringAnswer = input.next();
            competitionMember.trainingResult[answer - 1] = stringAnswer;
            System.out.print("\nDate that the new record was set: ");
            stringAnswer = input.next();
            competitionMember.date[answer - 1] = stringAnswer;
        }else if(answer == 0){
            System.out.println("Returning to Result Menu...");
        }else{
            System.out.println("The number " + answer + " is not a valid option");
        }
        /*
        switch (answer) {
            case 1:
                System.out.print("New best time for Crawl (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                competitionMember.trainingResult[0] = stringAnswer;
                System.out.print("\nDate that the new record was set: ");
                stringAnswer = input.next();
                competitionMember.date[0] = stringAnswer;
                break;
            case 2:
                System.out.print("New best time for Breaststroke (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                competitionMember.trainingResult[1] = stringAnswer;
                System.out.print("\nDate that the new record was set: ");
                stringAnswer = input.next();
                competitionMember.date[1] = stringAnswer;

                break;
            case 3:
                System.out.print("New best time for Butterfly (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                competitionMember.trainingResult[2] = stringAnswer;
                System.out.print("\nDate that the new record was set: ");
                stringAnswer = input.next();
                competitionMember.date[2] = stringAnswer;
                break;
            case 4:
                System.out.print("New best time for Backstroke (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                competitionMember.trainingResult[3] = stringAnswer;
                System.out.print("\nDate that the new record was set: ");
                stringAnswer = input.next();
                competitionMember.date[3] = stringAnswer;
                break;
            default:
                System.out.println("The number " + answer + " is not a valid option");
        }
         */
    }

    public void showCompetitionMembers(ArrayList<CompetitionMember> competitionMembers) {
        for (CompetitionMember s : competitionMembers) {
            System.out.printf("│Nr. %-12d │ Name: %-17s │ E-mail: %-27s │\n", competitionMembers.indexOf(s) + 1, s.fName, s.email);
            for (int i = 0; i < s.disciplinType.length; i++) {
                System.out.printf("│%-16s │ Best time: %-12s │ Date: %-29s │\n", s.disciplinType[i], s.trainingResult[i], s.date[i]);
            }
            System.out.println("├─────────────────┴─────────────────────────┴─────────────────────────────────────┤");
        }
    }


    public void showSpecificCompetitionMember(Scanner input, ArrayList<CompetitionMember> competitionMembers) {
        System.out.println("┌────────────────────────────── Competition Members ──────────────────────────────┐");
        showCompetitionMembers(competitionMembers);
        System.out.println("│                                 Enter 0 to exit                                 │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘\n");
        int choice = 1;
        while (choice != 0) {
            System.out.print("Enter number for which member you want to see: ");
            choice = input.nextInt();
            if (choice != 0 && choice <= competitionMembers.size()) {
                String myStatus = String.valueOf(competitionMembers.get(choice - 1).status);
                String myArrears = String.valueOf(competitionMembers.get(choice - 1).arrears);
                if (myStatus.equals("true")) {
                    myStatus = "Active";
                } else if (myStatus.equals("false")) {
                    myStatus = "Passive";
                }
                if (myArrears.equals("true")) {
                    myArrears = "Yes";
                } else if (myArrears.equals("false")) {
                    myArrears = "No";
                }
                System.out.printf("""
                                ┌──────────────────────────────────────────┬──────────────────────────────────────────────┐
                                │ SWIMMING CLUB DOLPHIN                    │                      ,-.                     │
                                │ MEMBERSHIP CARD                          │                     /  (                     │
                                │                                          │               _.--'!   '--._                 │
                                │ Status        : %-24s │              ,'              ''.             │
                                │ Activity form : %-24s │             |!                   \\           │
                                │ Team          : %-24s │           _.'  O      ___       ! \\          │
                                │ First name    : %-24s │          (_.-^, __..-'  ''''--.   )          │
                                │ Last name     : %-24s │              /,'             _.' /           │
                                │ Age           : %-24d │                          .-''    |           │
                                │ E-mail        : %-24s │                         (..--^.  '\\          │
                                │ Address       : %-24s │                               | /            │
                                │ Arrears       : %-24s │                               '              │
                                ├──────────────────────────────────────────┼─────────────────────────┬────────────────────┤
                                │ Disciplin type: %-24s │ Training result : %-4s │ Date : %-11s │
                                │ Disciplin type: %-24s │ Training result : %-4s │ Date : %-11s │
                                │ Disciplin type: %-24s │ Training result : %-4s │ Date : %-11s │
                                │ Disciplin type: %-24s │ Training result : %-4s │ Date : %-11s │
                                """,
                        myStatus, competitionMembers.get(choice - 1).activityType, competitionMembers.get(choice - 1).teamType,
                        competitionMembers.get(choice - 1).fName, competitionMembers.get(choice - 1).lName, competitionMembers.get(choice - 1).age,
                        competitionMembers.get(choice - 1).email, competitionMembers.get(choice - 1).address, myArrears,
                        competitionMembers.get(choice - 1).disciplinType[0], competitionMembers.get(choice - 1).trainingResult[0], competitionMembers.get(choice - 1).date[0],
                        competitionMembers.get(choice - 1).disciplinType[1], competitionMembers.get(choice - 1).trainingResult[1], competitionMembers.get(choice - 1).date[1],
                        competitionMembers.get(choice - 1).disciplinType[2], competitionMembers.get(choice - 1).trainingResult[2], competitionMembers.get(choice - 1).date[2],
                        competitionMembers.get(choice - 1).disciplinType[3], competitionMembers.get(choice - 1).trainingResult[3], competitionMembers.get(choice - 1).date[3]);
                System.out.println("├──────────────────────────────────────────┴─────────────────────────┴────────────────────┤");
                System.out.println("│                                     Enter 0 to exit                                     │");
                System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────┘\n");
            } else if (choice >= competitionMembers.size()){
                System.out.println("\nNumber " + choice + " is not a valid option\n");
            }
        }
    }

    public void topFiveTeamType(ArrayList<CompetitionMember> competitionMembers, Scanner input) {
        int pickTeamType = 1;
        while (pickTeamType != 0) {
            System.out.println("""
                    ┌───────────── Top 5 Menu ──────────────┐
                    │ Enter 0 for exit Team Type selection  │
                    │ Enter 1 for Senior top 5 list         │
                    │ Enter 2 for Junior top 5 list         │
                    └───────────────────────────────────────┘""");
            pickTeamType = input.nextInt();
            switch (pickTeamType) {
                case 1: //Senior
                    getTopFive(competitionMembers, input, "Senior");
                    break;
                case 2: //Junior
                    getTopFive(competitionMembers, input, "Junior");
                    break;
                default:
                    if (pickTeamType == 0) {
                        break;
                    } else {
                        System.out.println("Number " + pickTeamType + " is not a valid option");
                    }
            }
        }

    }

    public void getTopFive(ArrayList<CompetitionMember> competitionMembers, Scanner input, String teamT) {
        int pickTop5 = 1;
        while (pickTop5 != 0) {
            System.out.println("""
                    ┌───────────── Top 5 Menu ──────────────┐
                    │ Enter 0 for exit top 5 list selection │
                    │ Enter 1 for top 5 Crawl               │
                    │ Enter 2 for top 5 Breaststroke        │
                    │ Enter 3 for top 5 Butterfly           │
                    │ Enter 4 for top 5 Backstroke          │
                    └───────────────────────────────────────┘""");
            pickTop5 = input.nextInt();
            switch (pickTop5) {
                case 1: //Crawl
                    topFiveSort(competitionMembers, 0, teamT);
                    break;
                case 2: //Breaststroke
                    topFiveSort(competitionMembers, 1, teamT);
                    break;
                case 3: //Butterfly
                    topFiveSort(competitionMembers, 2, teamT);
                    break;
                case 4: //Backstroke
                    topFiveSort(competitionMembers, 3, teamT);
                    break;
                default:
                    if (pickTop5 == 0) {
                        break;
                    } else {
                        System.out.println("Number " + pickTop5 + " is not a valid option");
                    }
            }
        }
    }

    public void topFiveSort(ArrayList<CompetitionMember> competitionMembers, int type, String teamT) {
        CompetitionMember[] competitionMemberArray = new CompetitionMember[competitionMembers.size()];
        CompetitionMember[] tempArray = new CompetitionMember[1];
        int tempI = 1;
        String topFiveText = "┌────────── Top 5. for" + competitionMembers.get(0).disciplinType[type] + " " + "(" + teamT + ")"; //Set text of top five and disciplin to find the length.
        System.out.printf("┌────────── Top 5. for %s ", competitionMembers.get(0).disciplinType[type] + " " + "(" + teamT + ")"); //Print of text that say top five and what disciplin.
        for (int i = 1; i < (53 - topFiveText.length()); i++) { //Using for loop to print the end of top five text with "-"
            System.out.print("─");
        }
        System.out.println("┐");

        for (int i = 0; i < competitionMembers.size(); i++) {
            competitionMemberArray[i] = competitionMembers.get(i);
        }
        for (int i = 0; i < competitionMembers.size(); i++) {
            for (int j = i + 1; j < competitionMemberArray.length; j++) {
                if (competitionMemberArray[i].trainingResult[type].compareTo(competitionMemberArray[j].trainingResult[type]) > 0) {
                    tempArray[0] = competitionMemberArray[i];
                    competitionMemberArray[i] = competitionMemberArray[j];
                    competitionMemberArray[j] = tempArray[0];
                }
            }
            competitionMembers.set(i, competitionMemberArray[i]);
        }
        for (int i = 0; i < competitionMembers.size(); i++) {
            if (!competitionMembers.get(i).trainingResult[type].equals("00:00") && tempI != 6) {
                if (competitionMembers.get(i).teamType.equals(teamT) && competitionMembers.get(i).status) {
                    System.out.printf("│ %d%s │ Name: %-8s │ time %5s │ date %-10s │\n", tempI, topFivePlace(tempI), competitionMembers.get(i).fName, competitionMembers.get(i).trainingResult[type], competitionMembers.get(i).date[type]);
                    System.out.println("└─────────────────────────────────────────────────────┘");
                    tempI++;
                }
            }
        }
        System.out.println();
    }

    public String topFivePlace(int placement) {
        return switch (placement) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }

    public void makeMemberToCompetitionMember(Scanner input, ArrayList<Member> members, ArrayList<CompetitionMember> competitionMembers) {
        System.out.println("┌──────────────── Competition Swimmer List ────────────────┐");
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).activityType.equals("Competition Swimmer")) {
                System.out.printf("│ Nr. %-2d │ Name: %-8s │ E-mail: %-23s │\n", i + 1, members.get(i).fName, members.get(i).email);
            }
        }
        System.out.println("└───────────────────────────────────────────────────────────┘");
       /* int counter = 1;
        for (Member m : members) {
            System.out.println("Nr." + counter + "\n" + m + "\n********************************");
            counter++;
        } */
        System.out.print("Pick a member from the list above, that you want to make into a competition member.\nThe members nr: ");
        int answer = input.nextInt();
        Member changingMember = members.get(answer - 1);
        members.remove(answer - 1);

        CompetitionMember competitionMember = new CompetitionMember();

        competitionMember.status = changingMember.status;
        competitionMember.activityType = changingMember.activityType;
        competitionMember.teamType = changingMember.teamType;
        competitionMember.fName = changingMember.fName;
        competitionMember.lName = changingMember.lName;
        competitionMember.age = changingMember.age;
        competitionMember.email = changingMember.email;
        competitionMember.address = changingMember.address;
        competitionMember.arrears = changingMember.arrears;

        System.out.println("Do you want to add a result for the new competition member?\nType 1 for yes or 2 for no");
        int addResultAnswer = input.nextInt();
        if (addResultAnswer == 1) {
            System.out.println("""
                    ┌─ Which Swimming discipline do you want to add a new time to? ─┐
                    │ Type 1 for Crawl                                              │
                    │ Type 2 for Breaststroke                                       │
                    │ Type 3 for Butterfly                                          │
                    │ Type 4 for Backstroke                                         │
                    └───────────────────────────────────────────────────────────────┘""");

            String stringAnswer;
            boolean timeTestAnswer;
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    System.out.print("New best time for Crawl (MUST be written in this format: xx:xx): ");
                    stringAnswer = input.next();
                    timeTestAnswer = timeTester(competitionMember.trainingResult[0], stringAnswer);
                    if (!timeTestAnswer) {
                        System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[0]);
                    } else {
                        competitionMember.trainingResult[0] = stringAnswer;
                        System.out.print("\nDate that the new record was set: ");
                        stringAnswer = input.next();
                        competitionMember.date[0] = stringAnswer;
                    }
                    break;
                case 2:
                    System.out.print("New best time for Breaststroke (MUST be written in this format: xx:xx): ");
                    stringAnswer = input.next();
                    timeTestAnswer = timeTester(competitionMember.trainingResult[1], stringAnswer);
                    if (!timeTestAnswer) {
                        System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[1]);
                    } else {
                        competitionMember.trainingResult[1] = stringAnswer;
                        System.out.print("\nDate that the new record was set: ");
                        stringAnswer = input.next();
                        competitionMember.date[1] = stringAnswer;
                    }
                    break;
                case 3:
                    System.out.print("New best time for Butterfly (MUST be written in this format: xx:xx): ");
                    stringAnswer = input.next();
                    timeTestAnswer = timeTester(competitionMember.trainingResult[2], stringAnswer);
                    if (!timeTestAnswer) {
                        System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[2]);
                    } else {
                        competitionMember.trainingResult[2] = stringAnswer;
                        System.out.print("\nDate that the new record was set: ");
                        stringAnswer = input.next();
                        competitionMember.date[2] = stringAnswer;
                    }
                    break;
                case 4:
                    System.out.print("New best time for Backstroke (MUST be written in this format: xx:xx): ");
                    stringAnswer = input.next();
                    timeTestAnswer = timeTester(competitionMember.trainingResult[3], stringAnswer);
                    if (!timeTestAnswer) {
                        System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[3]);
                    } else {
                        competitionMember.trainingResult[3] = stringAnswer;
                        System.out.print("\nDate that the new record was set: ");
                        stringAnswer = input.next();
                        competitionMember.date[3] = stringAnswer;
                    }
                    break;
                default:
                    System.out.println("The number " + answer + " is not a valid option");
            }
            competitionMembers.add(competitionMember);
        } else if (addResultAnswer == 2) {
            competitionMembers.add(competitionMember);
        } else {
            System.out.println("Wrong input, please try again...");
        }
    }

    //Tester hvilken tid der er lavest. Stringen skal være i formatet: xx:xx.
    public boolean timeTester(String oldTimeString, String newTimeString) {
        if (oldTimeString.equals("00:00")) {
            return true;
        } else {
            String oldTimeMinString = oldTimeString.substring(0, oldTimeString.indexOf(":"));
            String oldTimeSecString = oldTimeString.substring(oldTimeString.indexOf(":") + 1);
            int oldTimeMin = Integer.parseInt(oldTimeMinString);
            int oldTimeSec = Integer.parseInt(oldTimeSecString);

            String newTimeMinString = newTimeString.substring(0, newTimeString.indexOf(":"));
            String newTimeSecString = newTimeString.substring(newTimeString.indexOf(":") + 1);
            int newTimeMin = Integer.parseInt(newTimeMinString);
            int newTimeSec = Integer.parseInt(newTimeSecString);

            if (newTimeMin <= oldTimeMin) {
                if (newTimeSec < oldTimeSec) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public void writeToCompetitionMemberList(ArrayList<CompetitionMember> competitionMembers) throws IOException {
        FileWriter writer = new FileWriter("Files/CompetitionMemberList");
        String tempCompetitionMember = "";
        for (int i = 0; i < competitionMembers.size(); i++) {
            if (competitionMembers.get(i).status) {
                tempCompetitionMember += "Active, ";
            } else {
                tempCompetitionMember += "Passive, ";
            }
            tempCompetitionMember += competitionMembers.get(i).activityType + ", ";
            tempCompetitionMember += competitionMembers.get(i).teamType + ", ";
            tempCompetitionMember += competitionMembers.get(i).fName + ", ";
            tempCompetitionMember += competitionMembers.get(i).lName + ", ";
            tempCompetitionMember += competitionMembers.get(i).age + ", ";
            tempCompetitionMember += competitionMembers.get(i).email + ", ";
            tempCompetitionMember += competitionMembers.get(i).address + ", ";
            if (competitionMembers.get(i).arrears) {
                tempCompetitionMember += "Yes, ";
            } else {
                tempCompetitionMember += "No, ";
            }
            tempCompetitionMember += competitionMembers.get(i).disciplinType[0] + " " + competitionMembers.get(i).disciplinType[1] + " "
                    + competitionMembers.get(i).disciplinType[2] + " " + competitionMembers.get(i).disciplinType[3] + ", ";
            tempCompetitionMember += competitionMembers.get(i).trainingResult[0] + " " + competitionMembers.get(i).trainingResult[1] + " "
                    + competitionMembers.get(i).trainingResult[2] + " " + competitionMembers.get(i).trainingResult[3] + ", ";
            tempCompetitionMember += competitionMembers.get(i).date[0] + " " + competitionMembers.get(i).date[1] + " "
                    + competitionMembers.get(i).date[2] + " " + competitionMembers.get(i).date[3];

            System.out.println(tempCompetitionMember);
            writer.write(tempCompetitionMember + "\n");

            tempCompetitionMember = ""; // til at nulstille tempCompetitionMember, inden det starter på det næste member.
        }
        writer.close();
    }

    public void updateCompetitionMemberList(ArrayList<CompetitionMember> competitionMembers) throws IOException {
        Scanner reader = new Scanner(new File("Files/CompetitionMemberList"));

        while (reader.hasNextLine()) {
            String[] splitArray = reader.nextLine().split(", ");
            if (splitArray[0].equals("Active")) {
                splitArray[0] = "true";
            } else {
                splitArray[0] = "false";
            }
            if (splitArray[8].equals("Yes")) {
                splitArray[8] = "true";
            } else {
                splitArray[8] = "false";
            }

            String disciplinTypeStringTemp = splitArray[9];
            String[] disciplinTypeArrayTemp = disciplinTypeStringTemp.split(" ");
            String[] disciplinTypeArray = {disciplinTypeArrayTemp[0], disciplinTypeArrayTemp[1], disciplinTypeArrayTemp[2], disciplinTypeArrayTemp[3]};
            String trainingResultStringTemp = splitArray[10];
            String[] trainingResultArrayTemp = trainingResultStringTemp.split(" ");
            String[] trainingResultArray = {trainingResultArrayTemp[0], trainingResultArrayTemp[1], trainingResultArrayTemp[2], trainingResultArrayTemp[3]};
            String dateStringTemp = splitArray[11];
            String[] dateArrayTemp = dateStringTemp.split(" ");
            String[] dateArray = {dateArrayTemp[0], dateArrayTemp[1], dateArrayTemp[2], dateArrayTemp[3]};

            CompetitionMember tempCompetitionMember = new CompetitionMember(Boolean.parseBoolean(splitArray[0]), splitArray[1],
                    splitArray[2], splitArray[3], splitArray[4], Integer.parseInt(splitArray[5]), splitArray[6], splitArray[7], Boolean.parseBoolean(splitArray[8]),
                    disciplinTypeArray, trainingResultArray, dateArray);

            competitionMembers.add(tempCompetitionMember);
        }
    }
}
