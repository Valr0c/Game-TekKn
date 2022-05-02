/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum.tugas_2;

/**
 *
 * @author ROCKY
 */
public class Bot {
    private int tot_hp, hp, punch, kick, ult;
    private String status;
    private boolean pernah_ult;

    public Bot() {
        tot_hp = 80;
        hp = 80;
        punch = 5;
        kick = 3;
        ult = 20;
        status = "No";
        pernah_ult = false;
    }

    public int getTot_hp() {
        return tot_hp;
    }

    public void setTot_hp(int tot_hp) {
        this.tot_hp = tot_hp;
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPunch() {
        return punch;
    }

    public void setPunch(int punch) {
        this.punch = punch;
    }

    public int getKick() {
        return kick;
    }

    public void setKick(int kick) {
        this.kick = kick;
    }

    public int getUlt() {
        return ult;
    }

    public void setUlt(int ult) {
        this.ult = ult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPernah_ult() {
        return pernah_ult;
    }

    public void setPernah_ult(boolean pernah_ult) {
        this.pernah_ult = pernah_ult;
    }
    
    
}
