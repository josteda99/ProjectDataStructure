package BussinnessLogic;

import data.BinarySearchTree;
import data.Celular;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Admins extends javax.swing.JFrame {

    public static class Trabajador implements Serializable {

        public int id;
        public String nombre;
        public String cargo;

        public Trabajador() {
        }

        public Trabajador(int id, String nombre, String cargo) {
            this.id = id;
            this.nombre = nombre;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "ID: " + id + '\n'
                    + "Nombre: " + nombre + '\n'
                    + "Cargo: " + cargo + '\n';
        }

    }

    public static class Hash implements Serializable {

        private LinkedList[] harray;

        public Hash(int size) {
            harray = new LinkedList[size];
            for (int i = 0; i < harray.length; i++) {
                harray[i] = new LinkedList();
            }
        }

        public void insert(int n) {
            if (harray[modHash(n)].add(n)) {
                System.out.println("item" + n + "not founds");
            }
        }

        public void remove(int n) {
            harray[modHash(n)].remove(n);
        }

        public void clear() {
            for (int i = 0; i < harray.length; i++) {
                for (int j = 0; j < harray[i].size(); j++) {
                    harray[modHash(i)].remove(j);
                }
            }
        }

        public void printHash() {
            //ArrayList<String> imprimidor = new ArrayList<>();
            String resul;
            for (int i = 0; i < harray.length; i++) {
                System.out.println(i);
                for (int j = 0; j < harray[i].size(); j++) {
                    System.out.print(harray[i].get(j) + " ");
                    //imprimidor.add(harray[i].get(j).toString());

                }
            }

        }

        private int modHash(int key) {
            return key % harray.length;
        }
    }

    public Admins() {
        initComponents();
        mostrar();
    }

    public void mostrar() {

        File arch = new File("Hash.txt");
        FileOutputStream sal = null;
        FileInputStream ent = null;
        ObjectOutputStream wri = null;
        ObjectInputStream rea = null;

        File arch1 = new File("Trabajadores.txt");
        FileOutputStream sal1 = null;
        FileInputStream ent1 = null;
        ObjectOutputStream wri1 = null;
        ObjectInputStream rea1 = null;

        Hash admins = new Hash(25);
        ArrayList<Trabajador> trabajadores = new ArrayList<>();

        try {
            System.out.println("Leyendo archivo");
            ent = new FileInputStream(arch);
            rea = new ObjectInputStream(ent);
            admins = (Hash) rea.readObject();

            ent1 = new FileInputStream(arch1);
            rea1 = new ObjectInputStream(ent1);
            trabajadores = (ArrayList<Trabajador>) rea1.readObject();

            //admins.clear();
            //System.out.println(admins);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (ent != null) {
                try {
                    ent.close();
                    if (rea != null) {
                        rea.close();
                    }
                } catch (IOException ex) {
                    //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("no se pudo");
                }
            }
        }
        //--------------Escritura de archivo--------------------
        try {
            System.out.println("Escribiendo en archivo");

            arch.createNewFile();
            sal = new FileOutputStream(arch);
            wri = new ObjectOutputStream(sal);

            arch1.createNewFile();
            sal1 = new FileOutputStream(arch1);
            wri1 = new ObjectOutputStream(sal1);

            System.out.println("Ingrese el numero de trabajadores");
            Scanner sc = new Scanner(System.in);

            System.out.println("1 para insertar, 2 para borrar, cualquier otro pasar");

            int opc = sc.nextInt();

            if (opc == 1) {
                int n = sc.nextInt();

                String[] cargos = {"admin", "matenimiento", "cargador", "distribuidor"};
                for (int i = 0; i < n; i++) {
                    int car = (int) (Math.random() * 4);
                    Trabajador t = new Trabajador(i, "pedro", cargos[car]);
                    trabajadores.add(t);
                    admins.insert(t.id);

                }

            }

            if (opc == 2) {
                admins.clear();
                trabajadores.clear();

            }

            wri.writeObject(admins);
            wri1.writeObject(trabajadores);
            //System.exit(0);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sal != null) {
                try {
                    sal.close();
                    if (wri != null) {
                        wri.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("INFORMACION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );

        jLabel3.setText("BUSCADOR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel2.setText("ID");

        txtInfo.setColumns(20);
        txtInfo.setRows(5);
        jScrollPane2.setViewportView(txtInfo);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        File arch = new File("Hash.txt");
        FileOutputStream sal = null;
        FileInputStream ent = null;
        ObjectOutputStream wri = null;
        ObjectInputStream rea = null;

        File arch1 = new File("Trabajadores.txt");
        FileOutputStream sal1 = null;
        FileInputStream ent1 = null;
        ObjectOutputStream wri1 = null;
        ObjectInputStream rea1 = null;

        Hash admins = new Hash(25);
        ArrayList<Trabajador> trabajadores = new ArrayList<>();

        try {
            System.out.println("Leyendo archivo");
            ent = new FileInputStream(arch);
            rea = new ObjectInputStream(ent);
            admins = (Hash) rea.readObject();

            ent1 = new FileInputStream(arch1);
            rea1 = new ObjectInputStream(ent1);
            trabajadores = (ArrayList<Trabajador>) rea1.readObject();

            //admins.clear();
            //System.out.println(admins);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (ent != null) {
                try {
                    ent.close();
                    if (rea != null) {
                        rea.close();
                    }
                } catch (IOException ex) {
                    //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("no se pudo");
                }
            }
        }
        //--------------Escritura de archivo--------------------
        try {
            System.out.println("Escribiendo en archivo");

            arch.createNewFile();
            sal = new FileOutputStream(arch);
            wri = new ObjectOutputStream(sal);

            arch1.createNewFile();
            sal1 = new FileOutputStream(arch1);
            wri1 = new ObjectOutputStream(sal1);

            int idBuscar = Integer.parseInt(txtId.getText());

            for (int i = 0; i < trabajadores.size(); i++) {
                if (idBuscar == trabajadores.get(i).id) {
                    txtInfo.setText(trabajadores.get(i).toString());
                }
            }
            wri.writeObject(admins);
            wri1.writeObject(trabajadores);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sal != null) {
                try {
                    sal.close();
                    if (wri != null) {
                        wri.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Admins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admins().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables
}
