package BussinnessLogic;

import java.io.*;
import javax.swing.table.DefaultTableModel;
import data.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PantallaTienda extends javax.swing.JFrame {

    DefaultTableModel dtmClientes = new DefaultTableModel();
    DefaultTableModel dtmInventario = new DefaultTableModel();
    DefaultTableModel dtmCatalogo = new DefaultTableModel();
    Cliente cliente = null;
    ArrayList<Cliente> pedidos = new ArrayList<>();
    Celular celular = null;
    ArrayList<Celular> inventario = new ArrayList<>();
    Queue<Cliente> despachador = new ArrayDeque<>();

    public PantallaTienda() {

        initComponents();
        setModel();

        File archivo = new File("ClientesArray.txt");
        File archivo1 = new File("InventarioArray.txt");
        File archivo2 = new File("Despachador.txt");
        FileOutputStream salida = null;
        FileInputStream entrada = null;
        FileOutputStream salida1 = null;
        FileInputStream entrada1 = null;
        FileOutputStream salida2 = null;
        FileInputStream entrada2 = null;
        ObjectOutputStream writer = null;
        ObjectOutputStream writer1 = null;
        ObjectOutputStream writer2 = null;
        ObjectInputStream reader = null;
        ObjectInputStream reader1 = null;
        ObjectInputStream reader2 = null;

        try {
            System.out.println("Leyendo archivo");
            entrada = new FileInputStream(archivo);
            entrada1 = new FileInputStream(archivo1);
            entrada2 = new FileInputStream(archivo2);
            reader = new ObjectInputStream(entrada);
            reader1 = new ObjectInputStream(entrada1);
            reader2 = new ObjectInputStream(entrada2);
            pedidos = (ArrayList<Cliente>) reader.readObject();
            inventario = (ArrayList<Celular>) reader1.readObject();
            despachador = (Deque<Cliente>) reader2.readObject();

            setDatosListaClientes(pedidos);
            // for (Cliente variable : pedidos) {
            //    System.out.println(variable.toString());
            //}
            setDatosListaInventario(inventario);
            //for (Celular variable : inventario) {
            //  System.out.println(variable.toString());
            //}
            setDatosCatalogo(inventario);
            for (Cliente variable : despachador) {
                System.out.println(variable.toString());
            }
            int ganancias = 0;
            int may = 0;
            for (int i = 0; i < pedidos.size(); i++) {
                ganancias = ganancias + pedidos.get(i).getPrecioPago();
            }
            
            if (ganancias > may) {
                may = ganancias;
                String txtDin = Integer.toString(may);
                txtDinero.setText(txtDin);
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                    if (reader != null) {
                        reader.close();
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
            archivo.createNewFile();
            salida = new FileOutputStream(archivo);
            writer = new ObjectOutputStream(salida);

            archivo1.createNewFile();
            salida1 = new FileOutputStream(archivo1);
            writer1 = new ObjectOutputStream(salida1);

            archivo2.createNewFile();
            salida2 = new FileOutputStream(archivo2);
            writer2 = new ObjectOutputStream(salida2);
            //cliente = new Cliente(1019283567, "Johan", "Daza", "efectivo", 300000, "h2grhdbs");
            // pedidos.add(cliente);
            //System.out.println(pedidos.element().toString());
            writer.writeObject(pedidos);
            writer1.writeObject(inventario);
            writer2.writeObject(despachador);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                    if (writer != null) {
                        writer.close();
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

        jInternalFrameCliente = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCatalogo = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cbFormaPago = new javax.swing.JComboBox();
        Comprar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jInternalFrame2Admin = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jbtnIngresarCecular = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnDespachar = new javax.swing.JButton();
        btnInsertarInventario = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtDinero = new javax.swing.JLabel();
        clieBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTClientes = new javax.swing.JTable();
        jlClientes = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTInventario = new javax.swing.JTable();
        jlInventario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrameCliente.setVisible(true);

        jLabel5.setText("EQUIPOS DISPONIBLES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        jTCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTCatalogo);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        jLabel1.setText("ID");

        jLabel2.setText("Forma Pago");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbFormaPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Efectivo", "Tarjeta de Credito" }));

        Comprar.setText("Comprar");
        Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarActionPerformed(evt);
            }
        });

        jLabel6.setText("INFORMACION");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(cbFormaPago, 0, 190, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Comprar))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Comprar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jInternalFrameClienteLayout = new javax.swing.GroupLayout(jInternalFrameCliente.getContentPane());
        jInternalFrameCliente.getContentPane().setLayout(jInternalFrameClienteLayout);
        jInternalFrameClienteLayout.setHorizontalGroup(
            jInternalFrameClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrameClienteLayout.setVerticalGroup(
            jInternalFrameClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameClienteLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame2Admin.setVisible(true);

        jbtnIngresarCecular.setText("Ingresar Equipo");
        jbtnIngresarCecular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIngresarCecularActionPerformed(evt);
            }
        });

        btnReiniciar.setText("Reiniciar \nSistema"); // NOI18N
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar Inventario");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnDespachar.setText("Despachar");
        btnDespachar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespacharActionPerformed(evt);
            }
        });

        btnInsertarInventario.setText("Insertar Inventario");
        btnInsertarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarInventarioActionPerformed(evt);
            }
        });

        jLabel7.setText("Ganancias:");

        txtDinero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtDinero.setText("0");

        clieBtn.setText("Buscar BD Clientes");
        clieBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clieBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clieBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnIngresarCecular, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(btnReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDespachar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDinero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnIngresarCecular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDespachar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDinero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clieBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsertarInventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReiniciar)
                .addContainerGap())
        );

        jTClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTClientes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        jlClientes.setText("CLIENTES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jlClientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jlClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTInventario);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );

        jlInventario.setText("INVENTARIO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlInventario)
                .addGap(212, 212, 212))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlInventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame2AdminLayout = new javax.swing.GroupLayout(jInternalFrame2Admin.getContentPane());
        jInternalFrame2Admin.getContentPane().setLayout(jInternalFrame2AdminLayout);
        jInternalFrame2AdminLayout.setHorizontalGroup(
            jInternalFrame2AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2AdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame2AdminLayout.setVerticalGroup(
            jInternalFrame2AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2AdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jInternalFrame2AdminLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrameCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame2Admin))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrameCliente)
            .addComponent(jInternalFrame2Admin)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIngresarCecularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIngresarCecularActionPerformed
        new IngresarCelular().setVisible(true);
    }//GEN-LAST:event_jbtnIngresarCecularActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        reiniciarSistema(inventario, pedidos);
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //setDatosListaClientes(pedidos);
        //setDatosListaInventario(inventario);
        actualizadorInventario(inventario);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        new BuscarArbol().setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed

        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String formaPago = (String) cbFormaPago.getSelectedItem();
        int precio = Integer.parseInt((String) dtmCatalogo.getValueAt(jTCatalogo.getSelectedRow(), 2));
        int nSerie = Integer.parseInt((String) dtmCatalogo.getValueAt(jTCatalogo.getSelectedRow(), 1));
        //System.out.println(precio + "" + nSerie);

        File archivo = new File("ClientesArray.txt");
        File archivo1 = new File("InventarioArray.txt");
        File archivo2 = new File("Despachador.txt");
        FileOutputStream salida = null;
        FileInputStream entrada = null;
        FileOutputStream salida1 = null;
        FileInputStream entrada1 = null;
        FileOutputStream salida2 = null;
        FileInputStream entrada2 = null;
        ObjectOutputStream writer = null;
        ObjectOutputStream writer1 = null;
        ObjectOutputStream writer2 = null;
        ObjectInputStream reader = null;
        ObjectInputStream reader1 = null;
        ObjectInputStream reader2 = null;

        try {
            System.out.println("Leyendo archivo");
            entrada = new FileInputStream(archivo);
            entrada1 = new FileInputStream(archivo1);
            entrada2 = new FileInputStream(archivo2);
            reader = new ObjectInputStream(entrada);
            reader1 = new ObjectInputStream(entrada1);
            reader2 = new ObjectInputStream(entrada2);
            pedidos = (ArrayList<Cliente>) reader.readObject();
            inventario = (ArrayList<Celular>) reader1.readObject();
            despachador = (Deque<Cliente>) reader2.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                    if (reader != null) {
                        reader.close();
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
            archivo.createNewFile();
            salida = new FileOutputStream(archivo);
            writer = new ObjectOutputStream(salida);

            archivo1.createNewFile();
            salida1 = new FileOutputStream(archivo1);
            writer1 = new ObjectOutputStream(salida1);

            archivo2.createNewFile();
            salida2 = new FileOutputStream(archivo2);
            writer2 = new ObjectOutputStream(salida2);

            int i = 0;
            boolean bandera = false;
            while (bandera != true) {
                if (nSerie == inventario.get(i).getnSerie()) {
                    bandera = true;
                } else {
                    i++;
                }
            }

            if (inventario.get(i).getEstado().equals("Disponible")) {
                cliente = new Cliente(id, nombre, apellido, formaPago, precio, nSerie);
                pedidos.add(cliente);
                despachador.add(cliente);
                inventario.get(i).setEstado("Reservado");
                JOptionPane.showMessageDialog(null, "Reserva Exitosa", "Reserva", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El equipo ya esta reservado, porfavor intentelo de nuevo", "Error", JOptionPane.WARNING_MESSAGE);
            }

            writer.writeObject(pedidos);
            writer1.writeObject(inventario);
            writer2.writeObject(despachador);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

    }//GEN-LAST:event_ComprarActionPerformed

    private void btnDespacharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespacharActionPerformed

        File archivo = new File("ClientesArray.txt");
        File archivo1 = new File("InventarioArray.txt");
        File archivo2 = new File("Despachador.txt");
        FileOutputStream salida = null;
        FileInputStream entrada = null;
        FileOutputStream salida1 = null;
        FileInputStream entrada1 = null;
        FileOutputStream salida2 = null;
        FileInputStream entrada2 = null;
        ObjectOutputStream writer = null;
        ObjectOutputStream writer1 = null;
        ObjectOutputStream writer2 = null;
        ObjectInputStream reader = null;
        ObjectInputStream reader1 = null;
        ObjectInputStream reader2 = null;

        try {
            System.out.println("Leyendo archivo");
            entrada = new FileInputStream(archivo);
            entrada1 = new FileInputStream(archivo1);
            entrada2 = new FileInputStream(archivo2);
            reader = new ObjectInputStream(entrada);
            reader1 = new ObjectInputStream(entrada1);
            reader2 = new ObjectInputStream(entrada2);
            pedidos = (ArrayList<Cliente>) reader.readObject();
            inventario = (ArrayList<Celular>) reader1.readObject();
            despachador = (Deque<Cliente>) reader2.readObject();
            despachador.remove();
            int eliminador = pedidos.get(0).getnSerieCelular();

            Boolean bandera = false;
            int i = 0;
            while (bandera != true) {
                System.out.println(bandera);
                if (inventario.get(i).getnSerie() == eliminador) {
                    bandera = true;
                    inventario.remove(i);
                }
                i++;
            }
            pedidos.remove(0);

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                    if (reader != null) {
                        reader.close();
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
            archivo.createNewFile();
            salida = new FileOutputStream(archivo);
            writer = new ObjectOutputStream(salida);

            archivo1.createNewFile();
            salida1 = new FileOutputStream(archivo1);
            writer1 = new ObjectOutputStream(salida1);

            archivo2.createNewFile();
            salida2 = new FileOutputStream(archivo2);
            writer2 = new ObjectOutputStream(salida2);

            writer.writeObject(pedidos);
            writer1.writeObject(inventario);
            writer2.writeObject(despachador);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnDespacharActionPerformed

    private void btnInsertarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarInventarioActionPerformed
        File archivo = new File("InventarioArray.txt");
        FileOutputStream salida = null;
        FileInputStream entrada = null;
        ObjectOutputStream writer = null;
        ObjectInputStream reader = null;

        File archivo1 = new File("Arbol.txt");
        FileOutputStream salida1 = null;
        FileInputStream entrada1 = null;
        ObjectOutputStream writer1 = null;
        ObjectInputStream reader1 = null;
        Celular celular = null;
        //Queue<Cliente> pedidos = new ArrayDeque<Cliente>();
        ArrayList<Celular> inventario = new ArrayList<>();
        BinarySearchTree BusInventario = new BinarySearchTree();

        try {
            System.out.println("Leyendo archivo");
            entrada = new FileInputStream(archivo);
            reader = new ObjectInputStream(entrada);
            entrada1 = new FileInputStream(archivo1);
            reader1 = new ObjectInputStream(entrada1);

            inventario = (ArrayList<Celular>) reader.readObject();
            BusInventario = (BinarySearchTree) reader1.readObject();
            //inventario.clear();
            for (Celular variable : inventario) {
                System.out.println(variable.toString());
            }

            // BusInventario.
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                    if (reader != null) {
                        reader.close();
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
            archivo.createNewFile();
            salida = new FileOutputStream(archivo);
            writer = new ObjectOutputStream(salida);

            archivo1.createNewFile();
            salida1 = new FileOutputStream(archivo1);
            writer1 = new ObjectOutputStream(salida1);

            Scanner sc = new Scanner(System.in);
            String[] marcas = {"Huawei", "Samsung", "Nokia", "Alcatel", "Motorola",
                "Honor", "LG", "Sony", "Xiaomi", "Lenovo", "Blu", "Apple", "ZTE"};
            Random mar = new Random();
            System.out.println("Inserte en rango");
            int rango = sc.nextInt();
            for (int i = 0; i < rango; i++) {
                // System.out.println("nserie");
                int nSerie = i + 1;
                // System.out.println("marca");
                //sc.nextLine();
                int pos = mar.nextInt(13);
                String marca = marcas[pos];
                // System.out.println("price");
                int precio = mar.nextInt(1000000) + 1;
                //  System.out.println("imei");
                int imei = 100000000 - i;
                // System.out.println("insertado mi chino");

                celular = new Celular(nSerie, marca, precio, imei, "Disponible");
                inventario.add(celular);
                //BusInventario.insertBST(nSerie);
            }
            System.out.println("Terminado");
            writer.writeObject(inventario);
            //writer1.writeObject(BusInventario);
            System.exit(0);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnInsertarInventarioActionPerformed

    private void clieBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clieBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clieBtnActionPerformed

    public void reiniciarSistema(ArrayList<Celular> inventario, ArrayList<Cliente> pedidos) {
        File archivo = new File("ClientesArray.txt");
        File archivo1 = new File("InventarioArray.txt");
        FileOutputStream salida = null;
        FileInputStream entrada = null;
        FileOutputStream salida1 = null;
        FileInputStream entrada1 = null;
        ObjectOutputStream writer = null;
        ObjectOutputStream writer1 = null;
        ObjectInputStream reader = null;
        ObjectInputStream reader1 = null;

        try {
            System.out.println("Leyendo archivo");
            entrada = new FileInputStream(archivo);
            entrada1 = new FileInputStream(archivo1);
            reader = new ObjectInputStream(entrada);
            reader1 = new ObjectInputStream(entrada1);
            pedidos = (ArrayList<Cliente>) reader.readObject();
            inventario = (ArrayList<Celular>) reader1.readObject();

            pedidos.clear();
            inventario.clear();
            setDatosListaClientes(pedidos);
            for (Cliente variable : pedidos) {
                System.out.println(variable.toString());
            }
            setDatosListaInventario(inventario);
            for (Celular variable : inventario) {
                System.out.println(variable.toString());
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                    if (reader != null) {
                        reader.close();
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
            archivo.createNewFile();
            salida = new FileOutputStream(archivo);
            writer = new ObjectOutputStream(salida);

            archivo1.createNewFile();
            salida1 = new FileOutputStream(archivo1);
            writer1 = new ObjectOutputStream(salida1);
            //cliente = new Cliente(1019283567, "Johan", "Daza", "efectivo", 300000, "h2grhdbs");
            // pedidos.add(cliente);
            //System.out.println(pedidos.element().toString());
            writer.writeObject(pedidos);
            writer1.writeObject(inventario);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

    }

    public void lector() {
        File archivo = new File("ClientesArray.txt");
        File archivo1 = new File("InventarioArray.txt");
        FileOutputStream salida = null;
        FileInputStream entrada = null;
        FileOutputStream salida1 = null;
        FileInputStream entrada1 = null;
        ObjectOutputStream writer = null;
        ObjectOutputStream writer1 = null;
        ObjectInputStream reader = null;
        ObjectInputStream reader1 = null;

        try {
            System.out.println("Leyendo archivo");
            entrada = new FileInputStream(archivo);
            entrada1 = new FileInputStream(archivo1);
            reader = new ObjectInputStream(entrada);
            reader1 = new ObjectInputStream(entrada1);
            pedidos = (ArrayList<Cliente>) reader.readObject();
            inventario = (ArrayList<Celular>) reader1.readObject();

            pedidos.clear();
            inventario.clear();
            setDatosListaClientes(pedidos);
            for (Cliente variable : pedidos) {
                System.out.println(variable.toString());
            }
            setDatosListaInventario(inventario);
            for (Celular variable : inventario) {
                System.out.println(variable.toString());
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                    if (reader != null) {
                        reader.close();
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
            archivo.createNewFile();
            salida = new FileOutputStream(archivo);
            writer = new ObjectOutputStream(salida);

            archivo1.createNewFile();
            salida1 = new FileOutputStream(archivo1);
            writer1 = new ObjectOutputStream(salida1);
            //cliente = new Cliente(1019283567, "Johan", "Daza", "efectivo", 300000, "h2grhdbs");
            // pedidos.add(cliente);
            //System.out.println(pedidos.element().toString());
            writer.writeObject(pedidos);
            writer1.writeObject(inventario);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

    }

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
            java.util.logging.Logger.getLogger(PantallaTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaTienda().setVisible(true);
            }
        });

    }

    private void setDatosListaClientes(ArrayList<Cliente> clientes) {
        String[] datos = new String[3];

        for (int i = 0; i < clientes.size(); i++) {

            datos[0] = Integer.toString(clientes.get(i).getIdCliente());
            datos[1] = Integer.toString(clientes.get(i).getnSerieCelular());
            datos[2] = Integer.toString(clientes.get(i).getPrecioPago());
            dtmClientes.addRow(datos);

            //System.out.println(datos[0] + datos[1] + datos[2]);
        }

        jTClientes.setModel(dtmClientes);
    }

    private void setDatosListaInventario(ArrayList<Celular> inventario) {
        String[] datos = new String[5];

        for (int i = 0; i < inventario.size(); i++) {

            datos[0] = Integer.toString(inventario.get(i).getnSerie());
            datos[1] = inventario.get(i).getMarca();
            datos[2] = Integer.toString(inventario.get(i).getPrecio());
            datos[3] = Integer.toString(inventario.get(i).getImei());
            datos[4] = inventario.get(i).getEstado();
            dtmInventario.addRow(datos);

            //System.out.println(datos[0] + datos[1] + datos[2]);
        }

        jTInventario.setModel(dtmInventario);
    }

    private void setDatosCatalogo(ArrayList<Celular> inventario) {
        String[] datos = new String[4];

        for (int i = 0; i < inventario.size(); i++) {

            datos[0] = inventario.get(i).getMarca();
            datos[1] = Integer.toString(inventario.get(i).getnSerie());
            datos[2] = Integer.toString(inventario.get(i).getPrecio());
            datos[3] = inventario.get(i).getEstado();
            dtmCatalogo.addRow(datos);

            //System.out.println(datos[0] + datos[1] + datos[2]);
        }

        jTCatalogo.setModel(dtmCatalogo);
    }

    private void actualizadorInventario(ArrayList<Celular> inventario) {
        //lector();
        String[] datos = new String[4];

        System.out.println(inventario.size() + "" + dtmInventario.getRowCount());
        if (inventario.size() == dtmInventario.getRowCount()) {
            int i = dtmInventario.getRowCount();
            for (int j = i; j < inventario.size(); j++) {

                datos[0] = Integer.toString(inventario.get(j).getnSerie());
                datos[1] = inventario.get(i).getMarca();
                datos[2] = Integer.toString(inventario.get(j).getPrecio());
                datos[3] = Integer.toString(inventario.get(j).getImei());
                dtmInventario.addRow(datos);

                //System.out.println(datos[0] + datos[1] + datos[2]);
            }
        }

        jTInventario.setModel(dtmInventario);

    }

    private void setModel() {
        String[] cabeceraClientes = {"Identificacion", "Num Serie", "Precio"};
        String[] cabeceraInventario = {"nSerie", "Marca", "Precio", "IMEI", "Estado"};
        String[] cabeceraCatalogo = {"Marca", "nSerie", "Precio", "Estado"};
        dtmClientes.setColumnIdentifiers(cabeceraClientes);
        dtmInventario.setColumnIdentifiers(cabeceraInventario);
        dtmCatalogo.setColumnIdentifiers(cabeceraCatalogo);
        jTClientes.setModel(dtmClientes);
        jTInventario.setModel(dtmInventario);
        jTCatalogo.setModel(dtmCatalogo);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comprar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDespachar;
    private javax.swing.JButton btnInsertarInventario;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JComboBox cbFormaPago;
    private javax.swing.JButton clieBtn;
    private javax.swing.JInternalFrame jInternalFrame2Admin;
    private javax.swing.JInternalFrame jInternalFrameCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTCatalogo;
    private javax.swing.JTable jTClientes;
    private javax.swing.JTable jTInventario;
    private javax.swing.JButton jbtnIngresarCecular;
    private javax.swing.JLabel jlClientes;
    private javax.swing.JLabel jlInventario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JLabel txtDinero;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
