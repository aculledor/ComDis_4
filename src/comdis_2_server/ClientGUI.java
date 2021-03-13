/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comdis_2_server;

import java.util.ArrayList;

/**
 *
 * @author acull
 */
public class ClientGUI extends javax.swing.JFrame {

    public int prePort = 7777;
    public ArrayList<Integer> usedPorts;
    public ArrayList<ArrayList<String>> servers;

    /**
     * Creates new form ClientGUI_2
     */
    public ClientGUI() {
        initComponents();
        this.setVisible(true);
        System.out.println("Hola Mundo!");
        this.nameError.setVisible(false);
        this.portError.setVisible(false);
        this.pathError.setVisible(false);

        usedPorts = new ArrayList<>();
        usedPorts.add(prePort);

        servers = new ArrayList<>();
        this.printServers();

        this.work();
    }
    
    public void work() {

//            int RMIPort;
//            
//            String hostName;
//            InputStreamReader is = new InputStreamReader(System.in);
//            BufferedReader br = new BufferedReader(is);
//            System.out.println("Enter the RMIRegistry host namer:");
//            hostName = br.readLine();
//            System.out.println("Enter the RMIregistry port number:");
//            String portNum = br.readLine();
//            RMIPort = Integer.parseInt(portNum);
//            
//            String registryURL = "rmi://" + hostName + ":" + portNum + "/math";
//            // find the remote object and cast it to an interface object
//            MathInterface h = (MathInterface) Naming.lookup(registryURL);
//            System.out.println("Lookup completed ");
//            // invoke the remote method
//            Double[][] pairs = new Double[1][2];
//            pairs[0][0] = 0.11111;
//            pairs[0][1] = 0.22222;
//            Long resposta = h.validatePairs(pairs);
//            System.out.println("MathClient: " + resposta);
//} // end try 
//        catch (Exception e) {
//            System.out.println("Exception in MathClient: " + e);
//        }
    }

    public void printServers() {
        this.serverListArea.setText("Servers añadidos:\n");
        this.servers.forEach((server) -> {
            this.serverListArea.append("\t-" + "rmi://" + server.get(0) + ":" + server.get(1) + "/" + server.get(2) + "\n");
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pairNumberArea = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        serverNameArea = new javax.swing.JTextField();
        serverPathArea = new javax.swing.JTextField();
        serverPortArea = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        serverListArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        addServerBTN = new javax.swing.JButton();
        autofillBTN = new javax.swing.JButton();
        nameError = new javax.swing.JLabel();
        portError = new javax.swing.JLabel();
        pathError = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        pairNumberArea1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Indica el número de pares a verificar");

        pairNumberArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pairNumberArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pairNumberAreaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Log");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Puerto");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Path");

        serverNameArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        serverPathArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        serverPathArea.setText("math");
        serverPathArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverPathAreaActionPerformed(evt);
            }
        });

        serverPortArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("localhost");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        serverListArea.setColumns(20);
        serverListArea.setRows(5);
        jScrollPane1.setViewportView(serverListArea);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Lista de servidores");

        addServerBTN.setBackground(new java.awt.Color(102, 255, 102));
        addServerBTN.setForeground(new java.awt.Color(0, 0, 0));
        addServerBTN.setText("Añadir");
        addServerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addServerBTNActionPerformed(evt);
            }
        });

        autofillBTN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        autofillBTN.setText("autofill");
        autofillBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autofillBTNActionPerformed(evt);
            }
        });

        nameError.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nameError.setForeground(new java.awt.Color(255, 0, 0));
        nameError.setText("*");

        portError.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        portError.setForeground(new java.awt.Color(255, 0, 0));
        portError.setText("*");

        pathError.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pathError.setForeground(new java.awt.Color(255, 0, 0));
        pathError.setText("*");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Añade servidores:");

        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane2.setViewportView(logArea);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Resultado");

        pairNumberArea1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pairNumberArea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pairNumberArea1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Reimprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pathError))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nameError))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(portError)))
                            .addGap(16, 16, 16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(serverPathArea, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(serverPortArea)
                                .addComponent(serverNameArea))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(autofillBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(addServerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pairNumberArea1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pairNumberArea))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pairNumberArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(serverNameArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(nameError))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(serverPortArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(autofillBTN)
                                    .addComponent(portError))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(serverPathArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(pathError)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(addServerBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pairNumberArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap())
            .addComponent(jSeparator1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pairNumberAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pairNumberAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pairNumberAreaActionPerformed

    private void serverPathAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverPathAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverPathAreaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.serverNameArea.setText("localhost");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addServerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServerBTNActionPerformed
        // TODO add your handling code here:
        if (this.serverNameArea.getText().isEmpty()) {
            this.nameError.setVisible(true);
            this.portError.setVisible(false);
            this.pathError.setVisible(false);
        } else if (this.serverPortArea.getText().isEmpty() || this.usedPorts.contains(Integer.parseInt(this.serverPortArea.getText()))) {
            this.portError.setVisible(true);
            this.nameError.setVisible(false);
            this.pathError.setVisible(false);
        } else if (this.serverPathArea.getText().isEmpty()) {
            this.nameError.setVisible(false);
            this.portError.setVisible(false);
            this.pathError.setVisible(true);
        } else {
            this.nameError.setVisible(false);
            this.portError.setVisible(false);
            this.pathError.setVisible(false);
            this.usedPorts.add(Integer.parseInt(this.serverPortArea.getText()));

            ArrayList<String> server = new ArrayList<>();
            server.add(this.serverNameArea.getText().trim());
            server.add(this.serverPortArea.getText().trim());
            server.add(this.serverPathArea.getText().trim());
            this.servers.add(server);

            this.printServers();
            this.serverNameArea.setText("");
            this.serverPortArea.setText("");
        }
    }//GEN-LAST:event_addServerBTNActionPerformed

    private void autofillBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autofillBTNActionPerformed
        // TODO add your handling code here:
        Integer port = this.prePort;
        while (this.usedPorts.contains(port)) {
            port++;
        }
        this.serverPortArea.setText(port.toString());
    }//GEN-LAST:event_autofillBTNActionPerformed

    private void pairNumberArea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pairNumberArea1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pairNumberArea1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.printServers();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addServerBTN;
    private javax.swing.JButton autofillBTN;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea logArea;
    private javax.swing.JLabel nameError;
    private javax.swing.JTextField pairNumberArea;
    private javax.swing.JTextField pairNumberArea1;
    private javax.swing.JLabel pathError;
    private javax.swing.JLabel portError;
    private javax.swing.JTextArea serverListArea;
    private javax.swing.JTextField serverNameArea;
    private javax.swing.JTextField serverPathArea;
    private javax.swing.JTextField serverPortArea;
    // End of variables declaration//GEN-END:variables
}
