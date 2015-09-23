package eu.isas.peptideshaker.gui.filtering;

import com.compomics.util.experiment.filtering.FilterItem;
import com.compomics.util.experiment.filtering.FilterItemComparator;
import com.compomics.util.gui.utils.user_choice.ListChooser;
import com.compomics.util.gui.utils.user_choice.list_choosers.PtmChooser;
import com.compomics.util.gui.utils.user_choice.list_choosers.StringListChooser;
import com.compomics.util.preferences.IdentificationParameters;
import eu.isas.peptideshaker.filtering.MatchFilter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * Dialog to edit identification matches filters.
 *
 * @author Marc Vaudel
 */
public class FilterDialog extends javax.swing.JDialog {

    /**
     * Boolean indicating whether the user canceled the filtering.
     */
    private boolean canceled = false;
    /**
     * The original filter.
     */
    private MatchFilter matchFilter;
    /**
     * The names of the items to display.
     */
    private ArrayList<String> itemsNames = null;
    /**
     * The parent frame.
     */
    private java.awt.Frame parentFrame = null;
    /**
     * The identification parameters used for the project.
     */
    private IdentificationParameters identificationParameters;

    /**
     * Creates and displays a new dialog.
     *
     * @param parent the parent frame
     * @param filter the filter to edit
     * @param identificationParameters the identification parameters used for
     * the project
     */
    public FilterDialog(java.awt.Frame parent, MatchFilter filter, IdentificationParameters identificationParameters) {
        super(parent, true);
        this.parentFrame = parent;
        this.identificationParameters = identificationParameters;
        this.matchFilter = filter.clone();
        initComponents();
        setUpGUI();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    /**
     * Sets up the GUI components.
     */
    public void setUpGUI() {

        // make sure that the scroll panes are see-through
        filterItemsTableScrollPane.getViewport().setOpaque(false);

        filterItemsTable.getTableHeader().setReorderingAllowed(false);

        nameTxt.setText(matchFilter.getName());
        descriptionTxt.setText(matchFilter.getDescription());

        String text = "";
        for (String key : matchFilter.getManualValidation()) {
            if (!text.equals("")) {
                text += "; ";
            }
            text += key;
        }
        manualValidationTxt.setText(text);

        text = "";
        for (String accession : matchFilter.getExceptions()) {
            if (!text.equals("")) {
                text += "; ";
            }
            text += accession;
        }
        exceptionsTxt.setText(text);

        setUpTable();
    }

    /**
     * Updates the table content according to the selected filter.
     */
    public void setUpTable() {

        DefaultTableModel tableModel = new FilterItemsTableModel();
        filterItemsTable.setModel(tableModel);
        TableColumnModel tableColumnModel = filterItemsTable.getColumnModel();
        tableColumnModel.getColumn(0).setMaxWidth(50);

        TableColumn nameColumn = tableColumnModel.getColumn(1);
        JComboBox comboBox = new JComboBox(matchFilter.getPossibleFilterItemsNames());
        nameColumn.setCellEditor(new DefaultCellEditor(comboBox));

        TableColumn comparatorColumn = tableColumnModel.getColumn(2);
        comparatorColumn.setMaxWidth(300);
        comboBox = new JComboBox(FilterItemComparator.values());
        comparatorColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }

    /**
     * Updates the table.
     */
    public void updateTable() {
        setUpTable();
        ((DefaultTableModel) filterItemsTable.getModel()).fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemPopupMenu = new javax.swing.JPopupMenu();
        addItemMenuItem = new javax.swing.JMenuItem();
        removeItemMenuItem = new javax.swing.JMenuItem();
        filterPanel = new javax.swing.JPanel();
        filterSplitPane = new javax.swing.JSplitPane();
        propertiesPanel = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        descriptionLbl = new javax.swing.JLabel();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JTextArea();
        filterSettingsPanel = new javax.swing.JPanel();
        manualSelectionSplitPane = new javax.swing.JSplitPane();
        manualValidationPanel = new javax.swing.JPanel();
        manualValidationScrollPane = new javax.swing.JScrollPane();
        manualValidationTxt = new javax.swing.JTextArea();
        exceptionsPanel = new javax.swing.JPanel();
        exceptionsScrollPane = new javax.swing.JScrollPane();
        exceptionsTxt = new javax.swing.JTextArea();
        filterItemsPanel = new javax.swing.JPanel();
        filterItemsTableScrollPane = new javax.swing.JScrollPane();
        filterItemsTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        addItemMenuItem.setText("Add Item");
        addItemMenuItem.setToolTipText("Add a new filter item");
        addItemMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemMenuItemActionPerformed(evt);
            }
        });
        itemPopupMenu.add(addItemMenuItem);

        removeItemMenuItem.setText("Remove Item");
        removeItemMenuItem.setToolTipText("Removes the filter item");
        removeItemMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removeItemMenuItemMouseReleased(evt);
            }
        });
        itemPopupMenu.add(removeItemMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filter Editor (beta)");

        filterPanel.setBackground(new java.awt.Color(230, 230, 230));

        filterSplitPane.setBorder(null);
        filterSplitPane.setDividerLocation(200);
        filterSplitPane.setDividerSize(0);
        filterSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        filterSplitPane.setOpaque(false);

        propertiesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter Properties"));
        propertiesPanel.setOpaque(false);

        nameLbl.setText("Name");

        descriptionLbl.setText("Description");

        descriptionTxt.setColumns(20);
        descriptionTxt.setRows(3);
        descriptionScrollPane.setViewportView(descriptionTxt);

        javax.swing.GroupLayout propertiesPanelLayout = new javax.swing.GroupLayout(propertiesPanel);
        propertiesPanel.setLayout(propertiesPanelLayout);
        propertiesPanelLayout.setHorizontalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionScrollPane)
                    .addGroup(propertiesPanelLayout.createSequentialGroup()
                        .addGroup(propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLbl)
                            .addGroup(propertiesPanelLayout.createSequentialGroup()
                                .addComponent(nameLbl)
                                .addGap(18, 18, 18)
                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        propertiesPanelLayout.setVerticalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

        filterSplitPane.setLeftComponent(propertiesPanel);

        filterSettingsPanel.setOpaque(false);

        manualSelectionSplitPane.setBorder(null);
        manualSelectionSplitPane.setDividerLocation(425);
        manualSelectionSplitPane.setDividerSize(0);
        manualSelectionSplitPane.setOpaque(false);

        manualValidationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manual Validation"));
        manualValidationPanel.setOpaque(false);

        manualValidationScrollPane.setOpaque(false);

        manualValidationTxt.setColumns(20);
        manualValidationTxt.setRows(1);
        manualValidationScrollPane.setViewportView(manualValidationTxt);

        javax.swing.GroupLayout manualValidationPanelLayout = new javax.swing.GroupLayout(manualValidationPanel);
        manualValidationPanel.setLayout(manualValidationPanelLayout);
        manualValidationPanelLayout.setHorizontalGroup(
            manualValidationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manualValidationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manualValidationScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );
        manualValidationPanelLayout.setVerticalGroup(
            manualValidationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manualValidationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manualValidationScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        manualSelectionSplitPane.setLeftComponent(manualValidationPanel);

        exceptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Exceptions"));
        exceptionsPanel.setOpaque(false);

        exceptionsScrollPane.setOpaque(false);

        exceptionsTxt.setColumns(20);
        exceptionsTxt.setRows(1);
        exceptionsScrollPane.setViewportView(exceptionsTxt);

        javax.swing.GroupLayout exceptionsPanelLayout = new javax.swing.GroupLayout(exceptionsPanel);
        exceptionsPanel.setLayout(exceptionsPanelLayout);
        exceptionsPanelLayout.setHorizontalGroup(
            exceptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exceptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exceptionsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );
        exceptionsPanelLayout.setVerticalGroup(
            exceptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exceptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exceptionsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        manualSelectionSplitPane.setRightComponent(exceptionsPanel);

        filterItemsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter Item"));
        filterItemsPanel.setOpaque(false);

        filterItemsTable.setModel(new FilterItemsTableModel());
        filterItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                filterItemsTableMouseReleased(evt);
            }
        });
        filterItemsTableScrollPane.setViewportView(filterItemsTable);

        javax.swing.GroupLayout filterItemsPanelLayout = new javax.swing.GroupLayout(filterItemsPanel);
        filterItemsPanel.setLayout(filterItemsPanelLayout);
        filterItemsPanelLayout.setHorizontalGroup(
            filterItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterItemsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterItemsTableScrollPane)
                .addContainerGap())
        );
        filterItemsPanelLayout.setVerticalGroup(
            filterItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterItemsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterItemsTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout filterSettingsPanelLayout = new javax.swing.GroupLayout(filterSettingsPanel);
        filterSettingsPanel.setLayout(filterSettingsPanelLayout);
        filterSettingsPanelLayout.setHorizontalGroup(
            filterSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterItemsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(manualSelectionSplitPane)
        );
        filterSettingsPanelLayout.setVerticalGroup(
            filterSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterItemsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manualSelectionSplitPane))
        );

        filterSplitPane.setRightComponent(filterSettingsPanel);

        okButton.setText("OK");
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

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filterPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(filterSplitPane))
                .addContainerGap())
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterSplitPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Set the filters and close the dialog.
     *
     * @param evt
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (validateInput()) {
            setFilter();
            dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * Close the dialog without saving.
     *
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        canceled = true;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Adds a new filter item.
     *
     * @param evt
     */
    private void addItemMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemMenuItemActionPerformed

        String filterItemName = null;
        String[] filterItems = matchFilter.getPossibleFilterItemsNames();
        HashSet<String> taken = matchFilter.getItemsNames();
        for (String name : filterItems) {
            if (!taken.contains(name)) {
                filterItemName = name;
                break;
            }
        }
        if (filterItemName != null) {
            FilterItemComparator filterItemComparator = FilterItemComparator.equal;
            Object value = new Double(0);
            matchFilter.setFilterItem(filterItemName, filterItemComparator, value);
            updateTable();
        }
    }//GEN-LAST:event_addItemMenuItemActionPerformed

    /**
     * Removes a filter item.
     *
     * @param evt
     */
    private void removeItemMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeItemMenuItemMouseReleased
        int row = filterItemsTable.getSelectedRow();
        if (row >= 0) {
            String itemName = filterItemsTable.getValueAt(row, 1).toString();
            matchFilter.removeFilterItem(itemName);
            updateTable();
        }
    }//GEN-LAST:event_removeItemMenuItemMouseReleased

    /**
     * Show the filter item pop up menu.
     *
     * @param evt
     */
    private void filterItemsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterItemsTableMouseReleased

        if (evt != null && filterItemsTable.rowAtPoint(evt.getPoint()) != -1) {
            int row = filterItemsTable.rowAtPoint(evt.getPoint());
            filterItemsTable.setRowSelectionInterval(row, row);
        }
        if (evt != null && evt.getButton() == MouseEvent.BUTTON3) {
            itemPopupMenu.show(filterItemsTable, evt.getX(), evt.getY());
        }
        if (evt != null && evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            int row = filterItemsTable.rowAtPoint(evt.getPoint());
            String itemName = itemsNames.get(row);
            editValue(itemName);
        }

    }//GEN-LAST:event_filterItemsTableMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addItemMenuItem;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionTxt;
    private javax.swing.JPanel exceptionsPanel;
    private javax.swing.JScrollPane exceptionsScrollPane;
    private javax.swing.JTextArea exceptionsTxt;
    private javax.swing.JPanel filterItemsPanel;
    private javax.swing.JTable filterItemsTable;
    private javax.swing.JScrollPane filterItemsTableScrollPane;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JPanel filterSettingsPanel;
    private javax.swing.JSplitPane filterSplitPane;
    private javax.swing.JPopupMenu itemPopupMenu;
    private javax.swing.JSplitPane manualSelectionSplitPane;
    private javax.swing.JPanel manualValidationPanel;
    private javax.swing.JScrollPane manualValidationScrollPane;
    private javax.swing.JTextArea manualValidationTxt;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel propertiesPanel;
    private javax.swing.JMenuItem removeItemMenuItem;
    // End of variables declaration//GEN-END:variables

    /**
     * Lets the user edit the value for an item if predefined choices are used.
     *
     * @param row the name of the item to which the new value should be attached
     */
    private void editValue(String itemName) {
        FilterItem filterItem = matchFilter.getFilterItem(itemName);
        ListChooser listChooser = null;
        if (filterItem.isPtm()) {
            ArrayList<String> ptms = identificationParameters.getSearchParameters().getPtmSettings().getAllModifications();
            if (ptms != null && ptms.size() > 0) {
                listChooser = new PtmChooser(parentFrame, ptms, false); //@TODO: allow multiple selection
            }
        } else {
            ArrayList<String> possibilities = filterItem.getPossibilities();
            if (possibilities != null && possibilities.size() > 0) {
                listChooser = new StringListChooser(parentFrame, possibilities, null, null, null, false);
            }
        }
        if (listChooser != null && !listChooser.isCanceled()) {
            matchFilter.setValueForItem(itemName, listChooser.getSelectedItem());
            updateTable();
        }
    }

    /**
     * Indicates whether the editing was canceled by the user.
     *
     * @return a boolean indicating whether the editing was canceled by the user
     */
    public boolean isCanceled() {
        return canceled;
    }

    /**
     * Returns the filter as set by the user.
     *
     * @return the filter
     */
    public MatchFilter getFilter() {
        return matchFilter;
    }

    /**
     * /**
     * Modifies the filter according to the user selection.
     */
    public void setFilter() {

        matchFilter.setName(nameTxt.getText());
        matchFilter.setDescription(descriptionTxt.getText());
        matchFilter.setManualValidation(parseAccessions(manualValidationTxt.getText()));
        matchFilter.setExceptions(parseAccessions(exceptionsTxt.getText()));

    }

    /**
     * Validates the input.
     *
     * @return a boolean indicating whether the input is valid
     */
    public boolean validateInput() {

        return true;
    }

    /**
     * Convenience method parsing keys in the manual validation/exception text
     * fields.
     *
     * @param text the text in the text field
     * @return a list of the parsed keys
     */
    private ArrayList<String> parseAccessions(String text) {
        ArrayList<String> result = new ArrayList<String>();
        String[] split = text.split(";"); //todo allow other separators
        for (String part : split) {
            if (!part.trim().equals("")) {
                result.add(part.trim());
            }
        }
        return result;
    }

    /**
     * Indicates whether something was input for the filter.
     *
     * @return a boolean indicating whether something was input for the filter
     */
    public boolean hasInput() {
        return false;
    }

    /**
     * Validates the input value by the user for the given filter item.
     *
     * @param filterItem the filter item of interest
     * @param value the value input by the user
     *
     * @return a boolean indicating whether the value given by the user can be
     * used for the given filter item.
     */
    private boolean validateInput(String filterItemName, Object value) {
        FilterItem filterItem = matchFilter.getFilterItem(filterItemName);
        if (filterItem.isNumber()) {
            String stringValue = value.toString();
            try {
                new Double(stringValue);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, stringValue + " cannot be used for item " + filterItem.getName() + ", number expected.", "File Not Found", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }

    /**
     * Table model for the filter items.
     */
    private class FilterItemsTableModel extends DefaultTableModel {

        public FilterItemsTableModel() {
            if (matchFilter != null) {
                itemsNames = new ArrayList<String>(matchFilter.getItemsNames());
                Collections.sort(itemsNames);
            }
        }

        @Override
        public int getRowCount() {
            if (itemsNames == null) {
                return 0;
            }
            return itemsNames.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return " ";
                case 1:
                    return "Name";
                case 2:
                    return "Type";
                case 3:
                    return "Value";
                default:
                    return "";
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            switch (column) {
                case 0:
                    return row + 1;
                case 1:
                    String itemName = itemsNames.get(row);
                    return itemName;
                case 2:
                    itemName = itemsNames.get(row);
                    return matchFilter.getComparatorForItem(itemName).name;
                case 3:
                    itemName = itemsNames.get(row);
                    return matchFilter.getValue(itemName);
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object value, int row, int column) {
            switch (column) {
                case 1:
                    final String finalItemName = value.toString();
                    String previousItem = itemsNames.get(row);
                    FilterItemComparator comparator = matchFilter.getComparatorForItem(previousItem);
                    Object filterValue = matchFilter.getValue(finalItemName);
                    matchFilter.removeFilterItem(previousItem);
                    matchFilter.setFilterItem(finalItemName, comparator, filterValue);
                    // invoke later to give time for components to update
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            editValue(finalItemName);
                        }
                    });
                    break;
                case 2:
                    String itemName = itemsNames.get(row);
                    matchFilter.setComparatorForItem(itemName, (FilterItemComparator) value);
                    break;
                case 3:
                    itemName = itemsNames.get(row);
                    if (validateInput(itemName, value)) {
                        matchFilter.setValueForItem(itemName, value);
                    }
            }
            updateTable();
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            for (int i = 0; i < getRowCount(); i++) {
                if (getValueAt(i, columnIndex) != null) {
                    return getValueAt(i, columnIndex).getClass();
                }
            }
            return String.class;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            switch (column) {
                case 1:
                case 2:
                    return true;
                case 3:
                    String itemName = itemsNames.get(row);
                    FilterItem filterItem = matchFilter.getFilterItem(itemName);
                    return !filterItem.isPtm() && filterItem.getPossibilities() == null;
                default:
                    return false;
            }
        }
    }
}