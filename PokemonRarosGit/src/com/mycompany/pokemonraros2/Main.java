/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemonraros2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class Main extends javax.swing.JFrame {

    private DefaultTableModel defaultTable;
    private Conexiones conexiones = new Conexiones();
    private ArrayList<Pokemon> cercanos = new ArrayList<>();
    private ArrayList<Pokemon> listaPokemon = new ArrayList<>();
    private ArrayList<Pokemon> cercanosTemp = new ArrayList<>();
    private double lat;
    private double lon;
    private NotificationPopup pop = new NotificationPopup();

    public Main() {
        initComponents();

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Actualizando");
                actualizar();

            }
        }, 0, 5, TimeUnit.SECONDS);

        defaultTable = new DefaultTableModel(new String[]{"Nombre", "Tiempo Restante", "Coordenadas"}, 0);
        jTable1.setModel(defaultTable);
        jTable2.setModel(new DefaultTableModel(new String[]{"Nombre", "Tiempo Restante", "Coordenadas"}, 0));

        new ExcelAdapter(jTable2);
        new ExcelAdapter(jTable1);

        this.lat = 0;
        this.lon = 0;
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.3
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        coordenadas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rafa se la come");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "as 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Coordenadas:");

        jLabel2.setText("Latitud:");

        jLabel3.setText("Longitud:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Sonido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(coordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.lat = Double.parseDouble(jTextField1.getText());
            this.lon = Double.parseDouble(jTextField2.getText());
            coordenadas.setText(lat + ", " + lon);
        } catch (NumberFormatException e) {
            coordenadas.setText(this.lat + ", " + this.lon);
        }


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
                    //javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    /* public void actualizar() {
    ArrayList<Pokemon> pokemonActuales = new ArrayList<>();

    defaultTable = new DefaultTableModel(new String[]{"Nombre", "Tiempo Restante", "Coordenadas"}, 0);
    jTable1.setModel(defaultTable);

    try {
    pokemonActuales = conexiones.getPokemon();
    for (Pokemon p : pokemonActuales) {
    if (Math.abs(p.getLat() - lat) < 1 && Math.abs(p.getLon() - lon) < 1 && !contiene(cercanos, p)) {
    addPokemon(p, jTable2);
    cercanos.add(p);

    new Thread() {
    @Override
    public void run() {
    try {
    pop.popup(p.getName() + " " + p.getLat() + ", " + p.getLon() + " -" + getRestante(p.getRestante())+"-", p.getIco(), jCheckBox1.isSelected());
    } catch (MalformedURLException ex) {
    //System.out.println("Error");
    }
    }

    }.start();
    //pop.popup(p.getName() + " " + p.getLat() + ", " + p.getLon(), p.getIco());
    //System.out.println("Adding: " + p);
    }
    addPokemon(p, jTable1);
    }

    for (Pokemon p : cercanos) {
    cercanosTemp.add(p);
    }
    for (Pokemon p : cercanos) {
    if (caducado(p)) {
    //System.out.println(p + " Esta caducado");
    eliminar(p);
    //System.out.println("Eliminado");
    } else {
    //System.out.println(p + " No caducado");
    }
    }

    cercanos = new ArrayList<>();

    for (Pokemon p : cercanosTemp) {
    cercanos.add(p);
    //actualizarHora(p);
    }

    for (Pokemon p : cercanos) {
    actualizarHora(p);
    }
    cercanosTemp = new ArrayList<>();

    } catch (IOException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    //System.out.println("error");
    } catch (ParseException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    //System.out.println("error");
    }

    }*/
    public void actualizar() {
        try {
            defaultTable = (DefaultTableModel) jTable1.getModel();

            ArrayList<Pokemon> pokemonActuales = conexiones.getPokemon();
            ArrayList<Pokemon> listaPokemonTemp = new ArrayList<>();

            for (Pokemon p : pokemonActuales) {
                if (!pokemonAgregado(jTable1, p)) {
                    listaPokemon.add(p);
                    addPokemon(p, jTable1);
                    System.out.println("Agregando " + p.getName());
                }
            }

            ArrayList<Pokemon> eliminarA = new ArrayList<>();

            for (Pokemon p : listaPokemon) {
                if (!caducado(p)) {
                    actualizarHora(p, jTable1);
                } else {
                    System.out.println(p.getName() + " caducado");
                    eliminarA.add(p);
                }
            }
            for (Pokemon p : eliminarA) {
                if (listaPokemon.remove(p)) {
                    eliminar(p, jTable1);
                    System.out.println("Eliminando " + p.getName());

                }
            }

            for (Pokemon p : listaPokemon) {
                if (Math.abs(p.getLat() - lat) < 1 && Math.abs(p.getLon() - lon) < 1 && !contiene(cercanos, p)) {
                    addPokemon(p, jTable2);
                    cercanos.add(p);

                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                pop.popup(p.getName() + " " + p.getLat() + ", " + p.getLon() + " -" + getRestante(p.getRestante()) + "-", p.getIco(), jCheckBox1.isSelected());
                            } catch (MalformedURLException ex) {
                                System.out.println("Error");
                            }
                        }

                    }.start();
                }
            }

            ArrayList<Pokemon> eliminarB = new ArrayList<>();

            for (Pokemon p : cercanos) {
                if (!caducado(p)) {
                    actualizarHora(p, jTable2);
                } else {
                    System.out.println(p.getName() + " caducado");
                    eliminarB.add(p);
                }
            }

            for (Pokemon p : eliminarB) {
                if (cercanos.remove(p)) {
                    eliminar(p, jTable2);
                    System.out.println("Eliminando " + p.getName());

                }
            }

            if (coordenadas.getText().contains("No")) {
                coordenadas.setText("Conexion reestablecida");
            }

        } catch (SocketTimeoutException ej) {
            System.out.println("No hay intenet");
            coordenadas.setText("No hay conexion a internet");

        } catch (UnknownHostException e) {

            coordenadas.setText("No hay conexion a internet");
        } catch (IOException ex) {

            System.out.println("error 1");
        } catch (ParseException ex) {

            System.out.println("error 2");
        } catch (RuntimeException e) {
            System.out.println("error " + e.getMessage() + e.getClass().getName());
            //throw (e);
        } catch (Exception e) {
            System.out.println("error " + e.getMessage() + e.getClass().getName());
        }

    }

    public boolean caducado(Pokemon pokemon) {
        Date actual = new Date();
        //SimpleDateFormat sdfAmerica = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        //sdfAmerica.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        if (actual.getTime() - pokemon.getRestante().getTime() > 0) {

            return true;
        }

        return false;
    }

    public boolean contiene(ArrayList<Pokemon> pokemons, Pokemon pokemon) {
        for (Pokemon p : pokemons) {
            if (igual(p, pokemon)) {
                return true;
            }
        }
        return false;
    }

    public boolean igual(Pokemon p1, Pokemon p2) {
        if (p1.getLat() == p2.getLat() && p1.getLon() == p2.getLon()) {
            return true;
        }

        return false;
    }

    public void addPokemon(Pokemon pokemon, JTable jtable) {
        DefaultTableModel de = (DefaultTableModel) jtable.getModel();

        String res = getRestante(pokemon.getRestante());

        //String datos[] = {pokemon.getName(), pokemon.getRestante().toString(), pokemon.getLat() + ", " + pokemon.getLon()};
        String datos[] = {pokemon.getName(), res, pokemon.getLat() + ", " + pokemon.getLon()};
        de.addRow(datos);

        //jtable.setModel(de);
    }

    public String getRestante(Date d) {
        long duration = d.getTime() - new Date().getTime();

        long sec = TimeUnit.MILLISECONDS.toSeconds(duration) % 60;
        long min = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
        String aux;
        if (sec > 9) {
            aux = "" + sec;
        } else {
            aux = "0" + sec;
        }
        return min + ":" + aux;
    }

    @Deprecated
    public void eliminar(Pokemon p) {
        cercanosTemp.remove(p);
        //System.out.println("Se pudo eliminar");

        DefaultTableModel d = new DefaultTableModel(new String[]{"Nombre", "Tiempo Restante", "Coordenadas"}, 0);
        jTable2.setModel(d);

        for (Pokemon ac : cercanosTemp) {
            addPokemon(ac, jTable2);
        }

        //System.out.println("Terminado de eliminar");
    }

    public void eliminar(Pokemon p, JTable j) {
        DefaultTableModel d = (DefaultTableModel) j.getModel();

        int tam = j.getRowCount();
        for (int i = 0; i < tam; i++) {
            String actual = j.getValueAt(i, 2).toString();
            if (actual.contains(p.getLat() + "") && actual.contains(p.getLon() + "")) {
                d.removeRow(i);
                return;
            }
        }

        //System.out.println("Terminado de eliminar");
    }

    public void actualizarHora(Pokemon pokemon) {

        //long duration = pokemon.getRestante().getTime() - new Date().getTime();
        String res = getRestante(pokemon.getRestante());
        DefaultTableModel d = (DefaultTableModel) jTable2.getModel();
        int i;
        for (i = 0; i < cercanosTemp.size(); i++) {
            //System.out.println(d.getValueAt(i, 2).toString());
            if (d.getValueAt(i, 2).toString().contains(pokemon.getLat() + "")) {
                //System.out.println("Encontado en " + i);
                break;
            }
        }
        d.setValueAt(pokemon.getName(), i, 0);
        d.setValueAt(res, i, 1);
        
    }

    public void actualizarHora(Pokemon pokemon, JTable j) {

        String res = getRestante(pokemon.getRestante());
        DefaultTableModel d = (DefaultTableModel) j.getModel();
        int i = -1;

        for (i = 0; i < d.getRowCount(); i++) {
            //System.out.println(d.getValueAt(i, 2).toString());
            if (d.getValueAt(i, 2).toString().contains(pokemon.getLat() + "")) {
                //System.out.println("Encontado en " + i);
                break;
            }
        }
        if (i == -1) {
            System.out.println("Hubo un error y no se encontró el pokemon");
            return;
        }
        d.setValueAt(pokemon.getName(), i, 0);
        d.setValueAt(res, i, 1);
        //d.setValueAt(pokemon.g, i, 2);
    }

    public boolean pokemonAgregado(ArrayList<Pokemon> pokemons, Pokemon pokemon) {
        for (Pokemon actual : pokemons) {
            if (igual(actual, pokemon)) {
                return true;
            }
        }
        return false;
    }

    public boolean pokemonAgregado(JTable pokemons, Pokemon pokemon) {
        DefaultTableModel aux = (DefaultTableModel) pokemons.getModel();
        int tam = aux.getRowCount();
        for (int i = 0; i < tam; i++) {
            String actual = aux.getValueAt(i, 2).toString();
            if (actual.contains(pokemon.getLat() + "") && actual.contains(pokemon.getLon() + "")) {
                return true;
            }
        }
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coordenadas;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
