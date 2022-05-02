package praktikum.tugas_2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        ArrayList<String> histori = new ArrayList<>();
        
        int inp, inp2;
        do {
            System.out.println("+==TekKn==+");
            System.out.println("1. Play");
            System.out.println("2. History");
            System.out.println("0. Exit");
            System.out.println(">> ");
            inp = Integer.parseInt(sc.nextLine());
            
            if (inp == 1) {
                System.out.println("Insert Name : ");
                String nama = sc.nextLine();
                Player p = new Player(nama);
                Bot b = new Bot();
                int level = 1;
                do {
                    System.out.println("+========== Fight ==========+");
                    System.out.print(p.getName());
                    for (int i = 0; i < 17-nama.length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.println("Bot " + level);
                    System.out.print("[");
                    for (int i = 0; i < p.getHp()/(p.getTot_hp()/10); i++) {
                        System.out.print("/");
                    }
                    for (int i = 0; i < 10-(p.getHp()/(p.getTot_hp()/10)); i++) {
                        System.out.print(" ");
                    }
                    System.out.print("]     [");
                    for (int i = 0; i < b.getHp()/(b.getTot_hp()/10); i++) {
                        System.out.print("/");
                    }
                    for (int i = 0; i < 10-(b.getHp()/(b.getTot_hp()/10)); i++) {
                        System.out.print(" ");
                    }
                    System.out.println("]");
                    System.out.print("HP : " + p.getHp());
                    for (int i = 0; i < 12-Integer.toString(p.getHp()).length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.println("HP : " + b.getHp());
                    System.out.print("Punch : " + p.getPunch());
                    for (int i = 0; i < 9-Integer.toString(p.getPunch()).length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.println("Punch : " + b.getPunch());
                    System.out.print("Kick : " + p.getKick());
                    for (int i = 0; i < 10-Integer.toString(p.getKick()).length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.println("Kick : " + b.getKick());
                    System.out.print("Status : " + p.getStatus());
                    for (int i = 0; i < 8-p.getStatus().length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.println("Status : " + b.getStatus());
                    System.out.println("+========== ===== ==========+");
                    System.out.println("1. Punch");
                    System.out.println("2. Kick");
                    System.out.println("3. Guard");
                    System.out.println("4. Ult");
                    do {
                        System.out.println(">> ");
                        inp2 = Integer.parseInt(sc.nextLine());
                        
                        if (inp2 == 4 && p.getStatus().equals("No")) {
                            System.out.println("Choose other action! Can't do Ult.");
                        }else break;
                    } while (true);
                    int inpbot = (b.getStatus().equals("No") ? rd.nextInt(3)+1 : rd.nextInt(4)+1);
                    
                    if (inp2 == 1) {
                        System.out.println("You use punch!");
                        if (inpbot == 1) {
                            System.out.println("Enemy use punch!");
                            p.setHp(p.getHp() - b.getPunch());
                            b.setHp(b.getHp() - p.getPunch());
                        }else if (inpbot == 2) {
                            System.out.println("Enemy use kick!");
                            p.setHp(p.getHp() - b.getKick());
                            b.setHp(b.getHp() - p.getPunch());
                        }else if (inpbot == 3) {
                            System.out.println("Enemy use guard!");
                        }else if (inpbot == 4 && !b.isPernah_ult()) {
                            System.out.println("Enemy use ult!");
                            b.setPernah_ult(true);
                            b.setStatus("No");
                            p.setHp(p.getHp() - b.getUlt());
                            b.setHp(b.getHp() - p.getPunch());
                        }
                    }else if (inp2 == 2) {
                        System.out.println("You use kick!");
                        if (inpbot == 1) {
                            System.out.println("Enemy use punch!");
                            p.setHp(p.getHp() - b.getPunch());
                            b.setHp(b.getHp() - p.getKick());
                        }else if (inpbot == 2) {
                            System.out.println("Enemy use kick!");
                            p.setHp(p.getHp() - b.getKick());
                            b.setHp(b.getHp() - p.getKick());
                        }else if (inpbot == 3) {
                            System.out.println("Enemy use guard!");
                            System.out.println("You kick hits!");
                            b.setHp(b.getHp() - p.getKick());
                        }else if (inpbot == 4 && !b.isPernah_ult()) {
                            System.out.println("Enemy use ult!");
                            b.setPernah_ult(true);
                            b.setStatus("No");
                            p.setHp(p.getHp() - b.getUlt());
                            b.setHp(b.getHp() - p.getKick());
                        }
                    }else if (inp2 == 3) {
                        System.out.println("You use guard!");
                        if (inpbot == 1) {
                            System.out.println("Enemy use punch!");
                        }else if (inpbot == 2) {
                            System.out.println("Enemy use kick!");
                            System.out.println("Enemy kick hits!");
                            p.setHp(p.getHp() - b.getKick());
                        }else if (inpbot == 3) {
                            System.out.println("Enemy use guard!");
                        }else if (inpbot == 4 && !b.isPernah_ult()) {
                            System.out.println("Enemy use ult!");
                            System.out.println("Enemy ult hits!");
                            b.setPernah_ult(true);
                            b.setStatus("No");
                            p.setHp(p.getHp() - b.getUlt());
                        }
                    }else if (inp2 == 4 && p.getStatus().equals("Yes") && !p.isPernah_ult()) {
                        System.out.println("You use ult!");
                        p.setPernah_ult(true);
                        p.setStatus("No");
                        if (inpbot == 1) {
                            System.out.println("Enemy use punch!");
                            p.setHp(p.getHp() - b.getPunch());
                            b.setHp(b.getHp() - p.getUlt());
                        }else if (inpbot == 2) {
                            System.out.println("Enemy use kick!");
                            p.setHp(p.getHp() - b.getKick());
                            b.setHp(b.getHp() - p.getUlt());
                        }else if (inpbot == 3) {
                            System.out.println("Enemy use guard!");
                            System.out.println("You ult hits!");
                            b.setHp(b.getHp() - p.getUlt());
                        }else if (inpbot == 4 && !b.isPernah_ult()) {
                            System.out.println("Enemy use ult!");
                            b.setPernah_ult(true);
                            b.setStatus("No");
                            p.setHp(p.getHp() - b.getUlt());
                            b.setHp(b.getHp() - p.getUlt());
                        }
                    }
                    
                    if ((double)p.getHp()/((double)p.getTot_hp()/10.0) <= 3 && !p.isPernah_ult()) {
                        p.setStatus("Yes");
                    }
                    if ((double)b.getHp()/((double)b.getTot_hp()/10.0) <= 3 && !b.isPernah_ult()) {
                        b.setStatus("Yes");
                    }
                    
                    if (b.getHp() <= 0 || inp2 == -1) {
                        level++;
                        p.setHp(p.getTot_hp() + 10);
                        p.setTot_hp(p.getHp());
                        p.setPunch(p.getPunch() + 5);
                        p.setKick(p.getKick() + 3);
                        p.setUlt(p.getUlt() + 10);
                        p.setStatus("No");
                        p.setPernah_ult(false);
                        b.setHp(b.getTot_hp() + 15);
                        b.setTot_hp(b.getHp());
                        b.setPunch(b.getPunch() + 5);
                        b.setKick(b.getKick() + 3);
                        b.setUlt(b.getUlt() + 10);
                        b.setStatus("No");
                        b.setPernah_ult(false);
                    }
                    if (p.getHp() <= 0 || level == 5) {
                        p.setScore(level);
                        break;
                    }
                } while (true);
                histori.add(p.getName() + " - " + Integer.toString(p.getScore()));
            }else if (inp == 2) {
                System.out.println("+========= Histori =========+");
                for (int i = 0; i < histori.size(); i++) {
                    System.out.println(i+1 + ". " + histori.get(i));
                }
                System.out.println("Press enter to continue!");
                String tmp = sc.nextLine();
            }
        } while (inp != 0);
        System.out.println("Good Bye.");
    }
    
}
