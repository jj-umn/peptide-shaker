package eu.isas.peptideshaker.gui;

import com.compomics.util.examples.BareBonesBrowserLaunch;
import java.io.File;
import javax.swing.JOptionPane;

/**
 * A dialog used to set up the connection between PeptideShaker and SearchGUI.
 *
 * @author Harald Barsnes
 */
public class SearchGuiSetupDialog extends javax.swing.JDialog {

    /**
     * A reference to PeptideShakerGUI.
     */
    private PeptideShakerGUI peptideShakerGUI;

    /**
     * Creates a new SearchGuiSetupDialog
     *
     * @param peptideShakerGUI a reference to PeptideShakerGUI
     * @param modal
     */
    public SearchGuiSetupDialog(PeptideShakerGUI peptideShakerGUI, boolean modal) {
        super(peptideShakerGUI, modal);
        this.peptideShakerGUI = peptideShakerGUI;

        initComponents();

        // display the current searchgui path
        if (peptideShakerGUI.getUserPreferences().getSearchGuiPath() != null) {
            searchGuiInstallationJTextField.setText(peptideShakerGUI.getUserPreferences().getSearchGuiPath());
        }

        setLocationRelativeTo(peptideShakerGUI);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        backgroundPanel = new javax.swing.JPanel();
        searchGuiInstallationPanel = new javax.swing.JPanel();
        searchGuiInstallationJTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        searchGuiJarFileHelpLabel = new javax.swing.JLabel();
        searchGuiDownloadPanel = new javax.swing.JPanel();
        searchGuiInfoLabel = new javax.swing.JLabel();
        searchGuiDownloadLinkLabel = new javax.swing.JLabel();
        searchGuiButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SearchGUI Settings");
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(230, 230, 230));

        searchGuiInstallationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("SearchGUI Installation"));
        searchGuiInstallationPanel.setOpaque(false);

        searchGuiInstallationJTextField.setEditable(false);
        searchGuiInstallationJTextField.setToolTipText("The folder containing the SearchGUI jar file.");

        browseButton.setText("Browse");
        browseButton.setToolTipText("The folder containing the SearchGUI jar file.");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        searchGuiJarFileHelpLabel.setFont(searchGuiJarFileHelpLabel.getFont().deriveFont((searchGuiJarFileHelpLabel.getFont().getStyle() | java.awt.Font.ITALIC)));
        searchGuiJarFileHelpLabel.setText("Please locate the folder containing the SearchGUI jar file. (SearchGUI v1.8.3 or newer!)");

        javax.swing.GroupLayout searchGuiInstallationPanelLayout = new javax.swing.GroupLayout(searchGuiInstallationPanel);
        searchGuiInstallationPanel.setLayout(searchGuiInstallationPanelLayout);
        searchGuiInstallationPanelLayout.setHorizontalGroup(
            searchGuiInstallationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchGuiInstallationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchGuiInstallationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(searchGuiInstallationPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchGuiJarFileHelpLabel))
                    .addComponent(searchGuiInstallationJTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(browseButton)
                .addContainerGap())
        );
        searchGuiInstallationPanelLayout.setVerticalGroup(
            searchGuiInstallationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchGuiInstallationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchGuiInstallationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchGuiInstallationJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchGuiJarFileHelpLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchGuiDownloadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Download SearchGUI"));
        searchGuiDownloadPanel.setOpaque(false);

        searchGuiInfoLabel.setFont(searchGuiInfoLabel.getFont().deriveFont(searchGuiInfoLabel.getFont().getStyle() | java.awt.Font.BOLD));
        searchGuiInfoLabel.setText("SearchGUI -  a graphical user interface for proteomics identification search engines");

        searchGuiDownloadLinkLabel.setText("<html><a href>http://searchgui.googlecode.com</a></html>");
        searchGuiDownloadLinkLabel.setToolTipText("Go to http://searchgui.googlecode.com");
        searchGuiDownloadLinkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchGuiDownloadLinkLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchGuiDownloadLinkLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchGuiDownloadLinkLabelMouseExited(evt);
            }
        });

        searchGuiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/searchgui-medium-shadow.png"))); // NOI18N
        searchGuiButton.setToolTipText("Go to http://searchgui.googlecode.com");
        searchGuiButton.setBorderPainted(false);
        searchGuiButton.setContentAreaFilled(false);
        searchGuiButton.setFocusPainted(false);
        searchGuiButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchGuiButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchGuiButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchGuiButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout searchGuiDownloadPanelLayout = new javax.swing.GroupLayout(searchGuiDownloadPanel);
        searchGuiDownloadPanel.setLayout(searchGuiDownloadPanelLayout);
        searchGuiDownloadPanelLayout.setHorizontalGroup(
            searchGuiDownloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchGuiDownloadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchGuiDownloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchGuiDownloadLinkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchGuiInfoLabel))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(searchGuiButton)
                .addContainerGap())
        );
        searchGuiDownloadPanelLayout.setVerticalGroup(
            searchGuiDownloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchGuiDownloadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchGuiInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchGuiDownloadLinkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(searchGuiDownloadPanelLayout.createSequentialGroup()
                .addComponent(searchGuiButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchGuiInstallationPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchGuiDownloadPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );

        backgroundPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchGuiInstallationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchGuiDownloadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Close the dialog without saving.
     *
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Open a file chooser were the user can select the SearchGUI jar file.
     *
     * @param evt
     */
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        File selectedFile = peptideShakerGUI.getUserSelectedFile(".jar", "SearchGUI jar file (.jar)", "Select SearchGUI Jar File", true);

        if (selectedFile != null) {
            if (!selectedFile.getName().endsWith(".jar")) {
                JOptionPane.showMessageDialog(this, "The selected file is not a jar file!", "Wrong File Selected", JOptionPane.WARNING_MESSAGE);
                okButton.setEnabled(false);
            } else if (selectedFile.getName().indexOf("SearchGUI") == -1) {
                JOptionPane.showMessageDialog(this, "The selected file is not a SearchGUI jar file!", "Wrong File Selected", JOptionPane.WARNING_MESSAGE);
                okButton.setEnabled(false);
            } else {
                // file assumed to be ok
                searchGuiInstallationJTextField.setText(selectedFile.getPath());
                okButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    /**
     * Save the SearchGUI mapping and close the dialog.
     *
     * @param evt
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        peptideShakerGUI.getUserPreferences().setSearchGuiPath(searchGuiInstallationJTextField.getText());
        peptideShakerGUI.saveUserPreferences();
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * Change the cursor to a hand cursor.
     *
     * @param evt
     */
    private void searchGuiDownloadLinkLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGuiDownloadLinkLabelMouseEntered
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_searchGuiDownloadLinkLabelMouseEntered

    /**
     * Change the cursor back to the default cursor.
     *
     * @param evt
     */
    private void searchGuiDownloadLinkLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGuiDownloadLinkLabelMouseExited
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_searchGuiDownloadLinkLabelMouseExited

    /**
     * Opens the SearchGUI web page.
     *
     * @param evt
     */
    private void searchGuiDownloadLinkLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGuiDownloadLinkLabelMouseClicked
        openSearchGuiWebPage();
    }//GEN-LAST:event_searchGuiDownloadLinkLabelMouseClicked

    /**
     * Change the cursor to a hand cursor.
     *
     * @param evt
     */
    private void searchGuiButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGuiButtonMouseEntered
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_searchGuiButtonMouseEntered

    /**
     * Change the cursor back to the default cursor.
     *
     * @param evt
     */
    private void searchGuiButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGuiButtonMouseExited
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_searchGuiButtonMouseExited

    /**
     * Opens the SearchGUI web page.
     *
     * @param evt
     */
    private void searchGuiButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGuiButtonMouseClicked
        openSearchGuiWebPage();
    }//GEN-LAST:event_searchGuiButtonMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton okButton;
    private javax.swing.JButton searchGuiButton;
    private javax.swing.JLabel searchGuiDownloadLinkLabel;
    private javax.swing.JPanel searchGuiDownloadPanel;
    private javax.swing.JLabel searchGuiInfoLabel;
    private javax.swing.JTextField searchGuiInstallationJTextField;
    private javax.swing.JPanel searchGuiInstallationPanel;
    private javax.swing.JLabel searchGuiJarFileHelpLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * Opens the SearchGUI web page.
     */
    private void openSearchGuiWebPage() {
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        BareBonesBrowserLaunch.openURL("http://searchgui.googlecode.com");
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
}
