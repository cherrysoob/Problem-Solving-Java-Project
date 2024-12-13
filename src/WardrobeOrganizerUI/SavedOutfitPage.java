/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package WardrobeOrganizerUI;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author AISHAH MAISARAH
 */
public class SavedOutfitPage extends javax.swing.JFrame {

    /**
     * Creates new form SavedOutfitPage
     */
    public SavedOutfitPage() {
        initComponents();
        setLocationRelativeTo(null); //center the JFrame
        
        // Add a WindowListener to handle the close button (X) click
        addWindowListener(new java.awt.event.WindowAdapter() { //WindowAdapter() is the parent class
            @Override //overrides method from parent class
            public void windowClosing(java.awt.event.WindowEvent e) { //windowClosing() is overriden
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the program
                }
            }
        });
        
        loadSavedOutfits();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Saved Outfit");
        setMinimumSize(new java.awt.Dimension(1080, 608));
        setPreferredSize(new java.awt.Dimension(1085, 625));
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(236, 230, 223));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(236, 230, 223));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(150, 129, 116));
        jPanel1.setBorder(null);
        jPanel1.setForeground(new java.awt.Color(236, 230, 223));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 400));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 30));
        jScrollPane1.setViewportView(jPanel1);
        jPanel1.setPreferredSize(new Dimension(jScrollPane1.getWidth(), jPanel1.getPreferredSize().height));

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 146, 960, 416);

        jButton1.setBackground(new java.awt.Color(236, 230, 223));
        jButton1.setFont(new java.awt.Font("Lucida Handwriting", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(77, 53, 46));
        jButton1.setText("Back ");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(59, 59, 229, 53);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SavedBG.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 608);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HomePage btn1 = new HomePage();
        btn1.show();
        dispose(); //completely dispose the window and its resources
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SavedOutfitPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SavedOutfitPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SavedOutfitPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SavedOutfitPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SavedOutfitPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    //method to read saved_outfit.txt file and return them as a list of arrays
    private List<String[]> loadSavedOutfitsFromFile() {
        //declare an ArrayList to hold the saved outfits
        List<String[]> outfits = new ArrayList<>();
        try {
            //checks if the file exists
            File file = new File("src\\datastorage\\saved_outfits.txt");
            if (!file.exists()) {
                return outfits; // Return an empty list if the file doesn't exist
            }

            //BufferedReader fetches chunks of data from the file into a memory buffer in one go (instead of reading characters one by one)
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line; //current line
            //BufferedReader reads the line one by one
            while ((line = reader.readLine()) != null) {
                // Split each line by ";" to extract paths in the array
                String[] outfitData = line.split(";");

                // Ensure there are at least 3 parts (top, bottom, shoes)
                if (outfitData.length >= 3) {
                    outfits.add(new String[] {
                        outfitData[0].trim(), // Top image path
                        outfitData[1].trim(), // Bottom image path
                        outfitData[2].trim(), // Shoes image path
                        outfitData.length > 3 ? outfitData[3].trim() : "" // "Other" image path (if present)
                    });
                }
            }

            reader.close();
        } catch (IOException e) {
            // Handle errors while reading the file
            JOptionPane.showMessageDialog(this, "Error reading saved outfits file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return outfits;
    }
    
    //method to position and display images dynamically
    private void loadSavedOutfits() {
        //the method loads saved outfits by calling loadSavedOutfitsFromFile()
        //each saved outfit is represented as an array of string
        List<String[]> savedOutfits = loadSavedOutfitsFromFile();
        // Clear existing panels in jPanel1
        jPanel1.removeAll();
        // Track the number of rows needed for the layout
        int itemCount = 0;
        for (String[] outfit : savedOutfits) {
            if (outfit.length >= 3) {  // Ensure we have at least Top, Bottom, and Shoes
                // Create the panel for this outfit combination
                JPanel outfitPanel = new JPanel(null); // Layout for top, bottom, shoes, and other
                outfitPanel.setBackground(new Color(236, 230, 223)); // Set background color
                outfitPanel.setPreferredSize(new Dimension(890, 265)); // Adjust size as needed

                // Add delete button for each combination
                JButton deleteButton = createDeleteButton(outfit);
                outfitPanel.add(deleteButton);

                // Add images for Top, Bottom, Shoes, and Other
                int xPosition = 35; // Initial x position for the first image
                int gap = 20; // Adjust this value to control the gap between images
                addImageToPanel(outfit[0], outfitPanel, xPosition); // Top
                xPosition += 190 + gap; // Adjust x position for the next image
                addImageToPanel(outfit[1], outfitPanel, xPosition); // Bottom
                xPosition += 190 + gap; // Adjust x position for the next image
                addImageToPanel(outfit[2], outfitPanel, xPosition); // Shoes
                if (outfit.length > 3 && !outfit[3].isEmpty()) {
                    xPosition += 190 + gap; // Adjust x position for the next image (Other)
                    addImageToPanel(outfit[3], outfitPanel, xPosition); // Other (if available)
                }

                // Add the outfit panel to the main jPanel1
                jPanel1.add(outfitPanel);

                itemCount++; // Increment item count for height calculation
            }
        }
        // Dynamically update the preferred size of jPanel1 based on the number of items
        int rows = (int) Math.ceil((double) itemCount / 1); // One row per outfit combination
        int panelHeight = rows * 305; // Adjust height per row
        jPanel1.setPreferredSize(new Dimension(jScrollPane1.getWidth(), panelHeight));
        // Refresh the panel
        jPanel1.revalidate(); //revalidate the panel's design (height, width, etc.)
        jPanel1.repaint(); //repaint or adjust the panel's design according to any changes
    }
    
    //method to add an image to a panel with dynamic positioning
    private void addImageToPanel(String imagePath, JPanel panel, int xPosition) {
        ImageIcon icon = new ImageIcon(imagePath);
        if (icon.getIconWidth() > 0 && icon.getIconHeight() > 0) {
            Image scaledImage = icon.getImage().getScaledInstance(190, 210, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imageLabel.setBounds(xPosition, 27, 190, 210); // Position the image based on xPosition
            panel.add(imageLabel);
            panel.revalidate();
            panel.repaint();
        } else {
            System.out.println("Failed to scale image: " + imagePath);
        }
        System.out.println("Loading image from path: " + imagePath);
        if (icon.getIconWidth() == -1) {
            System.out.println("Failed to load image: " + imagePath);
        }
    }

    //method to create a delete button for the outfit combination
    private JButton createDeleteButton(String[] outfit) {
        JButton deleteButton = new JButton(new ImageIcon("src/images/delete_icon.png"));
        deleteButton.setBounds(847, 7, 35, 40); // Adjusted for proportional alignment
        deleteButton.setBackground(new java.awt.Color(236, 230, 223));
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this outfit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                deleteOutfit(outfit); // Delete outfit combination
            }
        });
        return deleteButton;
    }

    //method to delete an outfit combination
    private void deleteOutfit(String[] outfit) {
        try {
            //Load all saved outfits by calling the loadSavedOutfitsFromFile() method
            List<String[]> savedOutfits = loadSavedOutfitsFromFile();
            //identify and remove the target outfit
            //removeIf() method is used to iterate over the savedOutfits list, if a match is found, the outfit is removed from the list
            savedOutfits.removeIf(o -> Arrays.equals(o, outfit));

            //Rewrite the updated list back to the saved_outfits.txt file
            //BufferedWriter stores the data in the memory buffer and writes all the data into the file in one go
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\datastorage\\saved_outfits.txt"))) {
                //iterates over every element in the savedOutfits list
                for (String[] savedOutfit : savedOutfits) { //for-each loop, the savedOutfit is assigned the current element from the list
                    writer.write(String.join(";", savedOutfit) + "\n");
                }
                JOptionPane.showMessageDialog(this, "Outfit deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
            loadSavedOutfits();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error deleting outfit: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
