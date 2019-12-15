package ir.maktab32.java.projects.scholarshipmanagement;

import ir.maktab32.java.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecase.*;
import ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecaseimpl.*;
import ir.maktab32.java.projects.scholarshipmanagement.features.usermanagement.usecase.LoginUseCase;
import ir.maktab32.java.projects.scholarshipmanagement.features.usermanagement.usecase.LogoutUseCase;
import ir.maktab32.java.projects.scholarshipmanagement.features.usermanagement.usecaseimpl.LoginUseCaseImpl;
import ir.maktab32.java.projects.scholarshipmanagement.features.usermanagement.usecaseimpl.LogoutUseCaseImpl;
import ir.maktab32.java.projects.scholarshipmanagement.model.Scholarship;
import ir.maktab32.java.projects.scholarshipmanagement.model.User;

import java.util.Scanner;

public class ScholarshipManagementApplication {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int manner = 0;

        while (manner != 7) {
            System.out.println("choose one...\n1.login\n2.logout\n3.Enter as a student\n4.Enter as the supervisor\n" +
                    "5.Enter as the manager\n6.Enter as an university\n7.exit\n===>>");
            manner = scan.nextInt();
            if (manner == 1) {
                System.out.print("Enter username...");
                String username = scan.next();
                System.out.print("Enter password...");
                String password = scan.next();
                LoginUseCase loginUseCase = new LoginUseCaseImpl();
                User user = loginUseCase.login(username, password);

            }
            if (manner == 2) {
                LogoutUseCase logoutUseCase = new LogoutUseCaseImpl();
                logoutUseCase.logout();
            }
            if (manner == 3) {
                System.out.println("\n1.list\n2.request");
                String command = scan.next();
                if (command.equals("1")) {
                    FindByStudentUseCase findByStudentUseCase = new FindByStudentUseCaseImpl();
                    for(Scholarship s : findByStudentUseCase.listScholarships()){
                        System.out.println(s);
                        System.out.println();
                    }
                } else if (command.equals("2")) {
                    System.out.print("Name: ");
                    String name = scan.next();
                    System.out.print("Family: ");
                    String family = scan.next();
                    System.out.print("NationalCode: ");
                    String nationalCode = scan.next();
                    System.out.print("Last University: ");
                    String lastUni = scan.next();
                    System.out.print("Last Degree: ");
                    String lastDegree = scan.next();
                    System.out.print("Last Field: ");
                    String lastField = scan.next();
                    System.out.print("Last Score: ");
                    float lastScore = scan.nextFloat();
                    System.out.print("Apply University: ");
                    String applyUni = scan.next();
                    System.out.print("Apply Degree: ");
                    String applyDegree = scan.next();
                    System.out.print("Apply Field: ");
                    String applyField = scan.next();
                    System.out.print("Apply Date: ");
                    String applyDate = scan.next();

                    Long requesterId = AuthenticationService.getInstance().getLoginUser().getId();

                    Scholarship scholarship = new Scholarship(null, "RequestedByStudent", name, family, nationalCode
                            , lastUni, lastDegree, lastField, lastScore, applyUni, applyDegree, applyField, applyDate, requesterId);

                    RequestByStudentUseCase requestByStudentUseCase = new RequestByStudentUseCaseImpl();
                    requestByStudentUseCase.request(scholarship);
                }
            }
            if (manner == 4) {
                System.out.println("\n1.list\n2.accept\n3.reject");
                String command = scan.next();
                if (command.equals("1")) {
                    FindBySupervisorUseCase findBySupervisorUsecase = new FindBySupervisorUseCaseImpl();
                    System.out.println(findBySupervisorUsecase.listScholarships());

                } else if (command.equals("2")) {
                    System.out.print("Which scholarship?");
                    Long scholarshipId = scan.nextLong();
                    AcceptBySupervisorUseCase acceptBySupervisorUseCase = new AcceptBySupervisorUseCaseImpl();
                    acceptBySupervisorUseCase.accept(scholarshipId);

                } else if (command.equals("3")) {
                    System.out.print("Which scholarship?");
                    Long scholarshipId = scan.nextLong();
                    RejectBySupervisorUseCase rejectBySupervisorUseCase = new RejectBySupervisorUseCaseImpl();
                    rejectBySupervisorUseCase.reject(scholarshipId);

                }
            }
            if (manner == 5){
                System.out.println("\n1.list\n2.accept\n3.reject");
                String command = scan.next();
                if (command.equals("1")) {
                    FindByManagerUseCase findByManagerUseCase = new FindByManagerUseCaseImpl();
                    System.out.println(findByManagerUseCase.listScholarships());

                } else if (command.equals("2")) {
                    System.out.print("Which scholarship?");
                    Long scholarshipId = scan.nextLong();
                    AcceptByManagerUseCase acceptByManagerUseCase = new AcceptByManagerUseCaseImpl();
                    acceptByManagerUseCase.accept(scholarshipId);

                } else if (command.equals("3")) {
                    System.out.print("Which scholarship?");
                    Long scholarshipId = scan.nextLong();
                    RejectByManagerUseCase rejectByManagerUseCase = new RejectByManagerUseCaseImpl();
                    rejectByManagerUseCase.reject(scholarshipId);
                }
            }
            if (manner == 6){
                System.out.println("\n1.list");
                String command = scan.next();
                if (command.equals("1")) {
                    FindByUniversityUseCase findByUniversityUseCase = new FindByUniversityUseCaseImpl();
                    for (Scholarship s : findByUniversityUseCase.listScholarships()) {
                        System.out.println(s);
                        System.out.println();
                    }
                }
            }
        }
    }
}
