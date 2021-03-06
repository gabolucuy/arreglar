package bo.edu.ucbcba.hotel.view;

import bo.edu.ucbcba.hotel.controller.RoomController;
import bo.edu.ucbcba.hotel.exceptions.ValidationException;
import bo.edu.ucbcba.hotel.model.Rooms;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Gabo on 15-May-16.
 */
public class RoomForm extends JDialog {
    private JPanel roomForm;
    private JTextField SearchField;
    private JTable RoomsTable;
    private JButton SearchButton;
    private JButton agregarHabitacionButton;
    private JButton verInventarioButton;
    private JButton eliminarHabitacionButton;
    private JButton salirButton;
    private JButton editarButton;
    private RoomController roomController;

    RoomForm(JFrame parent) {
        super(parent, "Rooms", true);
        pack();
        setContentPane(roomForm);
        setSize(650, 400);
        setBounds(400, 150, 650, 400);
        roomController = new RoomController();

        populateTable();
        eliminarHabitacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRoom();
                populateTable();
            }
        });
        agregarHabitacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchregistrer();
            }
        });


        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateTable();
            }
        });

        populateTable();

    }


    private void deleteRoom() {
        int n;
        DefaultTableModel tm = (DefaultTableModel) RoomsTable.getModel();
        n = (int) tm.getValueAt(RoomsTable.getSelectedRow(), 0);

        try {
            roomController.DeleteRoom(Integer.toString(n));
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Format error", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(this, "Room deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void launchregistrer() {
        NewRoomForm newroom = new NewRoomForm(this);
        newroom.setVisible(true);
        populateTable();

    }


    private void populateTable() {

        List<Rooms> roomsList = RoomController.searchRoom(SearchField.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("N° Habitacion");
        model.addColumn("Tipo");
        model.addColumn("Vista");
        model.addColumn("Disponibilidad");

        RoomsTable.setModel(model);

        for (Rooms s : roomsList) {
            Object[] row = new Object[4];

            row[0] = s.getRoomNumber();
            row[1] = s.getType();
            row[2] = s.getRoomView();
            if (!s.isAvailability())
                row[3] = "Disponible";
            else
                row[3] = "No Disponible";


            model.addRow(row);
        }
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        roomForm = new JPanel();
        roomForm.setLayout(new GridLayoutManager(3, 6, new Insets(10, 10, 10, 10), -1, -1));
        SearchField = new JTextField();
        roomForm.add(SearchField, new GridConstraints(0, 0, 1, 5, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        SearchButton = new JButton();
        SearchButton.setText("Buscar");
        roomForm.add(SearchButton, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        agregarHabitacionButton = new JButton();
        agregarHabitacionButton.setText("Agregar Habitación");
        roomForm.add(agregarHabitacionButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        verInventarioButton = new JButton();
        verInventarioButton.setText("Ver Inventario");
        roomForm.add(verInventarioButton, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        eliminarHabitacionButton = new JButton();
        eliminarHabitacionButton.setText("Eliminar Habitación");
        roomForm.add(eliminarHabitacionButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        salirButton = new JButton();
        salirButton.setText("Salir");
        roomForm.add(salirButton, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        editarButton = new JButton();
        editarButton.setText("Editar");
        roomForm.add(editarButton, new GridConstraints(2, 3, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        roomForm.add(scrollPane1, new GridConstraints(1, 0, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        RoomsTable = new JTable();
        scrollPane1.setViewportView(RoomsTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return roomForm;
    }
}
