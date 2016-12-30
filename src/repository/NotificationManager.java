/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import database.DatabaseManager;
import java.awt.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 *
 * @author Ugur Can
 */


public class NotificationManager {


    private ArrayList<Species> species;
    private Timer timer;
    public  NotificationManager(){

        timer = new Timer();
        timer.schedule(new NotifyTask(), 0, //initial delay
            1 * 1000 * 60); //subsequent rate
    }
    class NotifyTask extends TimerTask {

        public void run() {
            LocalDateTime now = LocalDateTime.now();
            DatabaseManager db = DatabaseManager.getInstance();
            species = db.getFeedingTimes();
            for(int i = 0; i< species.size();i++){
                if(species.get(i).getType()==0){
                    String date = species.get(i).getFeedingTime();
                    if(Integer.parseInt(date.substring(0,2)) == now.getHour() && Integer.parseInt(date.substring(3,5))-now.getMinute()==10){
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Feeding time of the animal "+species.get(i).getName()+" ID:"+species.get(i).getsID()+" is "+species.get(i).getFeedingTime());
                    }
                    else if(Integer.parseInt(date.substring(0,2)) - now.getHour() == -1 && Integer.parseInt(date.substring(3,5))-now.getMinute()==-50){
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Feeding time of the animal "+species.get(i).getName()+" ID:"+species.get(i).getsID()+" is "+species.get(i).getFeedingTime());
                    }
                }
                else{
                    String date = species.get(i).getFeedingTime();
                    Plant plant = (Plant)species.get(i);
                    String beginL = plant.getLightTimeStart();
                    String endL = plant.getLightTimeEnd();
                    if(Integer.parseInt(date.substring(0,2)) == now.getHour() && Integer.parseInt(date.substring(3,5))-now.getMinute()==10){
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Watering time of the plant "+species.get(i).getName()+" ID:"+species.get(i).getsID()+" is "+species.get(i).getFeedingTime());
                    }
                    else if(Integer.parseInt(date.substring(0,2)) - now.getHour() == -1 && Integer.parseInt(date.substring(3,5))-now.getMinute()==-50){
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Watering time of the plant "+species.get(i).getName()+" ID:"+species.get(i).getsID()+" is "+species.get(i).getFeedingTime());
                    }
                    if(Integer.parseInt(beginL.substring(0,2)) == now.getHour() && Integer.parseInt(beginL.substring(3,5))-now.getMinute()==10){
                        JFrame frame2 = new JFrame();
                        JOptionPane.showMessageDialog(frame2, "Light begin time of the plant "+species.get(i).getName()+" ID:"+species.get(i).getsID()+" is "+species.get(i).getFeedingTime());
                    }
                    else if(Integer.parseInt(beginL.substring(0,2)) - now.getHour() == -1 && Integer.parseInt(beginL.substring(3,5))-now.getMinute()==-50){
                        JFrame frame2 = new JFrame();
                        JOptionPane.showMessageDialog(frame2, "Light begin of the plant "+species.get(i).getName()+" ID:"+species.get(i).getsID()+" is "+species.get(i).getFeedingTime());
                    }
                    if(Integer.parseInt(endL.substring(0,2)) == now.getHour() && Integer.parseInt(endL.substring(3,5))-now.getMinute()==10){
                        JFrame frame3 = new JFrame();
                        JOptionPane.showMessageDialog(frame3, "Light end time of the plant "+species.get(i).getName()+" ID:"+species.get(i).getsID()+" is "+species.get(i).getFeedingTime());
                    }
                    else if(Integer.parseInt(endL.substring(0,2)) - now.getHour() == -1 && Integer.parseInt(endL.substring(3,5))-now.getMinute()==-50){
                        JFrame frame3 = new JFrame();
                        JOptionPane.showMessageDialog(frame3, "Light end of the plant "+species.get(i).getName()+" ID:"+species.get(i).getsID()+" is "+species.get(i).getFeedingTime());
                    }
                }
            }
        }
    }
}
