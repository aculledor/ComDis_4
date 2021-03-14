/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comdis_2_server;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acull
 */
public class ClientGUI extends javax.swing.JFrame {

    public int prePort = 7777;
    public long seed = 1102243;
    public int pairNum = 0;
    public ArrayList<Integer> usedPorts;
    public ArrayList<ArrayList<Long>> serverResult;
    public double result;
    public ArrayList<String> servers;
    public ArrayList<ArrayList<Double[]>> pairs;
    public Random random;
    public Thread[] threads;

    /**
     * Creates new form ClientGUI_2
     */
    public ClientGUI() {
        initComponents();
        this.setVisible(true);
        this.showServerErrors(false);
        
        usedPorts = new ArrayList<>();
        serverResult = new ArrayList<>();
        random = new Random(seed);
        servers = new ArrayList<>();
        result = 0;
        
        this.printServers();
    }
    
    public void showServerErrors(Boolean bool){
        this.nameError.setVisible(bool);
        this.portError.setVisible(bool);
        this.pathError.setVisible(bool);
    }
    
    public void setEditable(Boolean bool){
        this.pairNumberArea.setEditable(bool);
        this.serverNameArea.setEditable(bool);
        this.serverPortArea.setEditable(bool);
        this.serverPathArea.setEditable(bool);
        this.localhostBTN.setEnabled(bool);
        this.autofillBTN.setEnabled(bool);
        this.addServerBTN.setEnabled(bool);
        this.initBTN.setEnabled(bool);
    }
    
    public void work() {
        this.setEditable(false);
        this.pairNum = Integer.parseInt(this.pairNumberArea.getText());
        int serverNum = this.servers.size();
        int pairsPerServer = this.pairNum / serverNum;
        ArrayList<Double[]> auxList;
        this.pairs = new ArrayList<>();
        Double[] aux = new Double[2];
        
        //Data initalization
        for (int i = 0; i < serverNum - 1; i++) {
            auxList = new ArrayList<>();
            for (int j = 0; j < pairsPerServer; j++) {
                aux[0] = random.nextDouble();
                aux[1] = random.nextDouble();
                auxList.add(aux.clone());
            }
            this.pairs.add(auxList);
        }
        //Last iteration takes the rest
        auxList = new ArrayList<>();
        int rest = this.pairNum-pairsPerServer*(serverNum - 1);
        for (int j = 0; j < rest; j++) {
            aux[0] = random.nextDouble();
            aux[1] = random.nextDouble();
            auxList.add(aux.clone());
        }
        this.pairs.add(auxList);
        
        //Log
//        for (int i = 0; i < this.pairs.size(); i++) {
//            this.logArea.append("Server "+i+"\n");
//            this.pairs.get(i).forEach((pair)->{
//                this.logArea.append("\t["+pair[0]+","+pair[1]+"]\n");
//            });
//        }
        
        //Create threads
        threads = new Thread[serverNum];
        ArrayList<Long> auxArray;
        this.logArea.setText("Creando hilos\n");
        for (int i = 0; i < serverNum; i++) {
            auxArray = new ArrayList<>();
            this.serverResult.add(auxArray);
            threads[i] = new MathHilo("Hilo " + (i+1), this.pairs.get(i), this.servers.get(i), auxArray);
            this.logArea.append("\t-Hilo"+(i+1)+"]\n");
        }
        
        //Start threads
        this.logArea.setText("Iniciando hilos");
        for (int i = 0; i < serverNum; i++) {
            threads[i].start();
            this.logArea.append("\t-Hilo"+(i+1)+"]\n");
        }
        
        //Sync with threads
        this.logArea.setText("Esperando por los hilos");
        try {
            for (int i = 0; i < serverNum; i++) {
                threads[i].join();
                this.logArea.append("\t-Hilo"+(i+1)+"] ha acabado\n");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Show result
        this.logArea.setText("Mostrando resultado");
        this.serverResult.forEach((result)->{
            this.result += result.get(0);
        });
        this.result = (this.result/(float)this.pairNum)*4;
        this.resultArea.setText(String.valueOf(this.result));
        this.result = 0;
        
        this.setEditable(true);
    }

    public void printServers() {
        this.serverListArea.setText("Servers añadidos:\n");
        this.servers.forEach((server) -> {
            this.serverListArea.append("\t-" + server + "\n");
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
        resultArea = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        serverNameArea = new javax.swing.JTextField();
        serverPathArea = new javax.swing.JTextField();
        serverPortArea = new javax.swing.JTextField();
        localhostBTN = new javax.swing.JButton();
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
        pairNumberArea = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        initBTN = new javax.swing.JButton();
        initErrorText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Indica el número de pares a verificar");

        resultArea.setEditable(false);
        resultArea.setBackground(new java.awt.Color(255, 255, 255));
        resultArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        resultArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultAreaActionPerformed(evt);
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

        serverPortArea.setBackground(new java.awt.Color(255, 255, 255));
        serverPortArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        localhostBTN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        localhostBTN.setText("localhost");
        localhostBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localhostBTNActionPerformed(evt);
            }
        });

        serverListArea.setEditable(false);
        serverListArea.setColumns(20);
        serverListArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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

        logArea.setEditable(false);
        logArea.setColumns(20);
        logArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        logArea.setRows(5);
        jScrollPane2.setViewportView(logArea);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Resultado");

        pairNumberArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pairNumberArea.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        pairNumberArea.setText("0");
        pairNumberArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pairNumberAreaActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Reimprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        initBTN.setBackground(new java.awt.Color(0, 102, 102));
        initBTN.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        initBTN.setForeground(new java.awt.Color(255, 255, 255));
        initBTN.setText("Comenzar");
        initBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initBTNActionPerformed(evt);
            }
        });

        initErrorText.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        initErrorText.setForeground(new java.awt.Color(255, 0, 0));

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
                                .addComponent(localhostBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(autofillBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(addServerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pairNumberArea))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(initBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(resultArea))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(initErrorText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pairNumberArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(serverNameArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(localhostBTN)
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
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resultArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void resultAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultAreaActionPerformed

    private void serverPathAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverPathAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverPathAreaActionPerformed

    private void localhostBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localhostBTNActionPerformed
        // TODO add your handling code here:
        this.serverNameArea.setText("localhost");
    }//GEN-LAST:event_localhostBTNActionPerformed

    private void addServerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServerBTNActionPerformed
        // TODO add your handling code here:
        if (this.serverNameArea.getText().isEmpty()) {
            this.showServerErrors(false);
            this.nameError.setVisible(true);
        } else if (this.serverPortArea.getText().isEmpty() || this.usedPorts.contains(Integer.parseInt(this.serverPortArea.getText()))) {
            this.showServerErrors(false);
            this.portError.setVisible(true);
        } else if (this.serverPathArea.getText().isEmpty()) {
            this.showServerErrors(false);
            this.pathError.setVisible(true);
        } else {
            this.showServerErrors(false);
            this.usedPorts.add(Integer.parseInt(this.serverPortArea.getText()));
            
            this.servers.add("rmi://" + this.serverNameArea.getText().trim() + 
                    ":" + this.serverPortArea.getText().trim() + 
                    "/" + this.serverPathArea.getText().trim());

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

    private void pairNumberAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pairNumberAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pairNumberAreaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.printServers();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void initBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initBTNActionPerformed
        // TODO add your handling code here:
        if(this.servers.isEmpty()){
            this.initErrorText.setText("La lista de servidores está vacía");
        }else if(Integer.parseInt(this.pairNumberArea.getText()) <= 0){
            this.initErrorText.setText("El número de pares es incorrecto");
        }else{
            this.work();
        }
    }//GEN-LAST:event_initBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addServerBTN;
    private javax.swing.JButton autofillBTN;
    private javax.swing.JButton initBTN;
    private javax.swing.JLabel initErrorText;
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
    private javax.swing.JButton localhostBTN;
    private javax.swing.JTextArea logArea;
    private javax.swing.JLabel nameError;
    private javax.swing.JTextField pairNumberArea;
    private javax.swing.JLabel pathError;
    private javax.swing.JLabel portError;
    private javax.swing.JTextField resultArea;
    private javax.swing.JTextArea serverListArea;
    private javax.swing.JTextField serverNameArea;
    private javax.swing.JTextField serverPathArea;
    private javax.swing.JTextField serverPortArea;
    // End of variables declaration//GEN-END:variables
}
