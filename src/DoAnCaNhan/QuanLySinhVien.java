
package DoAnCaNhan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

public class QuanLySinhVien extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public QuanLySinhVien() {
        setTitle("Student Information");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Bảng hiển thị sinh viên
        model = new DefaultTableModel(new String[]{"Id", "Name", "Birthday", "Address", "Email"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Các nút chức năng
        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");
        JButton editBtn = new JButton("Edit");
        JButton refreshBtn = new JButton("Refresh");
        JButton exportBtn = new JButton("Export");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(refreshBtn);
        buttonPanel.add(exportBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Sự kiện nút
        addBtn.addActionListener(e -> addStudent());
        deleteBtn.addActionListener(e -> deleteStudent());
        editBtn.addActionListener(e -> editStudent());
        refreshBtn.addActionListener(e -> refreshTable());
        exportBtn.addActionListener(e -> exportToFile());
    }

    private void addStudent() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField birthField = new JTextField();
        JTextField addrField = new JTextField();
        JTextField emailField = new JTextField();

        Object[] inputFields = {
            "Id:", idField,
            "Name:", nameField,
            "Birthday:", birthField,
            "Address:", addrField,
            "Email:", emailField
        };

        int option = JOptionPane.showConfirmDialog(this, inputFields, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            model.addRow(new Object[]{
                idField.getText(),
                nameField.getText(),
                birthField.getText(),
                addrField.getText(),
                emailField.getText()
            });
        }
    }

    private void deleteStudent() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete.");
        }
    }

    private void editStudent() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String id = (String) model.getValueAt(row, 0);
            String name = (String) model.getValueAt(row, 1);
            String birth = (String) model.getValueAt(row, 2);
            String addr = (String) model.getValueAt(row, 3);
            String email = (String) model.getValueAt(row, 4);

            JTextField nameField = new JTextField(name);
            JTextField birthField = new JTextField(birth);
            JTextField addrField = new JTextField(addr);
            JTextField emailField = new JTextField(email);

            Object[] inputFields = {
                "Name:", nameField,
                "Birthday:", birthField,
                "Address:", addrField,
                "Email:", emailField
            };

            int option = JOptionPane.showConfirmDialog(this, inputFields, "Edit Student", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                model.setValueAt(nameField.getText(), row, 1);
                model.setValueAt(birthField.getText(), row, 2);
                model.setValueAt(addrField.getText(), row, 3);
                model.setValueAt(emailField.getText(), row, 4);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to edit.");
        }
    }

    private void refreshTable() {
        JOptionPane.showMessageDialog(this, "Table refreshed.");
    }

    private void exportToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.csv"))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                Vector<?> row = model.getDataVector().elementAt(i);
                writer.println(String.join(",", row.toString().replaceAll("[\\[\\]]", "").split(", ")));
            }
            JOptionPane.showMessageDialog(this, "Exported to students.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuanLySinhVien().setVisible(true));
    }
}