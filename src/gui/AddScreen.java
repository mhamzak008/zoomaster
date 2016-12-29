/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.DatabaseManager;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import repository.Animal;
import repository.Plant;

/**
 *
 * @author hamza
 */
public class AddScreen extends javax.swing.JPanel {

    /**
     * Creates new form AddScreen
     */
    public AddScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        animalRB = new javax.swing.JRadioButton();
        plantRB = new javax.swing.JRadioButton();
        nameL = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        latinNameL = new javax.swing.JLabel();
        latinNameTF = new javax.swing.JTextField();
        originCountryL = new javax.swing.JLabel();
        originCountryTF = new javax.swing.JTextField();
        specieSwitch = new javax.swing.JLayeredPane();
        animalAddScreen1 = new gui.AnimalAddScreen();
        plantAddScreen1 = new gui.PlantAddScreen();
        plantAddScreen1.setVisible(false);
        addB = new javax.swing.JButton();
        imageL = new javax.swing.JLabel();
        imageAddB = new javax.swing.JButton();
        clearFormB = new javax.swing.JButton();
        ageL = new javax.swing.JLabel();
        ageS = new javax.swing.JSpinner();

        buttonGroup1.add(animalRB);
        animalRB.setSelected(true);
        animalRB.setText("Animal");
        animalRB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                animalRBStateChanged(evt);
            }
        });

        buttonGroup1.add(plantRB);
        plantRB.setText("Plant");
        plantRB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                plantRBStateChanged(evt);
            }
        });
        plantRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plantRBActionPerformed(evt);
            }
        });

        nameL.setText("Name: ");

        latinNameL.setText("Latin Name:");

        originCountryL.setText("Origin Country:");

        specieSwitch.setLayer(animalAddScreen1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        specieSwitch.setLayer(plantAddScreen1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout specieSwitchLayout = new javax.swing.GroupLayout(specieSwitch);
        specieSwitch.setLayout(specieSwitchLayout);
        specieSwitchLayout.setHorizontalGroup(
            specieSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(animalAddScreen1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
            .addGroup(specieSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(specieSwitchLayout.createSequentialGroup()
                    .addComponent(plantAddScreen1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        specieSwitchLayout.setVerticalGroup(
            specieSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specieSwitchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(animalAddScreen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(specieSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(specieSwitchLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(plantAddScreen1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        addB.setText("Add Specie");
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });

        imageL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        imageAddB.setText("Add Image");
        imageAddB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageAddBActionPerformed(evt);
            }
        });

        clearFormB.setText("Clear Form");
        clearFormB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormBActionPerformed(evt);
            }
        });

        ageL.setText("Age:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(animalRB)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageAddB, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(addB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(plantRB)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(clearFormB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(latinNameL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(originCountryL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(ageL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameTF)
                                    .addComponent(latinNameTF, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ageS, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 227, Short.MAX_VALUE))
                                    .addComponent(originCountryTF)))
                            .addComponent(specieSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(imageL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(animalRB)
                    .addComponent(plantRB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageL, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imageAddB)
                        .addGap(18, 18, 18)
                        .addComponent(addB)
                        .addGap(24, 24, 24)
                        .addComponent(clearFormB)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameL)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(latinNameL)
                            .addComponent(latinNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(originCountryL)
                            .addComponent(originCountryTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ageL)
                            .addComponent(ageS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(specieSwitch)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void plantRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plantRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plantRBActionPerformed

    private void plantRBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_plantRBStateChanged
        // TODO add your handling code here:
        if(plantRB.isSelected())
        {
            animalAddScreen1.setVisible(false);
            plantAddScreen1.setVisible(true);
        }
    }//GEN-LAST:event_plantRBStateChanged

    private void animalRBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_animalRBStateChanged
        // TODO add your handling code here:
        if(animalRB.isSelected())
        {
           animalAddScreen1.setVisible(true);
           plantAddScreen1.setVisible(false); 
        }
    }//GEN-LAST:event_animalRBStateChanged

    private void imageAddBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageAddBActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        // Setting up a file filter
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory())
                {
                    return true;
                }
                else
                {
                    return     file.getName().toLowerCase().endsWith(".png")
                            || file.getName().toLowerCase().endsWith(".jpeg")
                            || file.getName().toLowerCase().endsWith(".jpg")
                            || file.getName().toLowerCase().endsWith(".gif");
                }
            }

            @Override
            public String getDescription() {
                return "Image Files"; 
            }
        });                         
               
        int res = chooser.showOpenDialog(AddScreen.this);
        if(res == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            // Creating ImageIcon out of the selected file
            ImageIcon image = new ImageIcon(file.getAbsolutePath());
            // Get width and height of imageLabel
            Rectangle rect = imageL.getBounds();
            // Scalling the Image to fit in the imageLabel
            Image scaledImage = image.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
            // Converting the image to ImageIcon to make it acceptable by imageLabel
            image = new ImageIcon(scaledImage);
            
            imageL.setIcon(image);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Action Cancelled!");
        }
        
        
    }//GEN-LAST:event_imageAddBActionPerformed

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
        // Getting Image and saving it into badge
        Rectangle rec = imageL.getBounds();
        BufferedImage badge = new BufferedImage(rec.width, rec.height, BufferedImage.TYPE_INT_ARGB);
        imageL.paint(badge.getGraphics());
        
        // Getting database access
        DatabaseManager dm = DatabaseManager.getInstance();
        boolean b; // database test variable
        
        // Creating specie and adding it to the database 
        if(animalRB.isSelected())
        {          
            
            Animal animal = new Animal(-1, 'n', 00, badge, nameTF.getText(), 
                                       animalAddScreen1.getFeedingTime(), latinNameTF.getText(), originCountryTF.getText(), 
                                       animalAddScreen1.getGender());
            
            b = dm.addDataEntry(animal);
            System.out.println("Animal Added = " + b);            
        }
        if(plantRB.isSelected())
        {
            Plant plant = new Plant(-1, plantAddScreen1.getLightTimeStart(), plantAddScreen1.getLightTimeEnd(),
                                    00, badge, nameTF.getText(), plantAddScreen1.getWateringTime(), 
                                    latinNameTF.getText(), originCountryTF.getText(), plantAddScreen1.getLightTone());
            
            b = dm.addDataEntry(plant);
            System.out.println("Plant Added = " + b);
        }        
        
    }//GEN-LAST:event_addBActionPerformed

    private void clearFormBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormBActionPerformed
        ageS.setValue(0);
        latinNameTF.setText("");
        nameTF.setText("");
        originCountryTF.setText("");
        plantAddScreen1.clear();
        animalAddScreen1.clear();
    }//GEN-LAST:event_clearFormBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addB;
    private javax.swing.JLabel ageL;
    private javax.swing.JSpinner ageS;
    private gui.AnimalAddScreen animalAddScreen1;
    private javax.swing.JRadioButton animalRB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearFormB;
    private javax.swing.JButton imageAddB;
    private javax.swing.JLabel imageL;
    private javax.swing.JLabel latinNameL;
    private javax.swing.JTextField latinNameTF;
    private javax.swing.JLabel nameL;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel originCountryL;
    private javax.swing.JTextField originCountryTF;
    private gui.PlantAddScreen plantAddScreen1;
    private javax.swing.JRadioButton plantRB;
    private javax.swing.JLayeredPane specieSwitch;
    // End of variables declaration//GEN-END:variables
}
