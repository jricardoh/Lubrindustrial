/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Equipment;
import com.lubrindustrial.Server.EquipmentCRUD;
import com.lubrindustrial.Server.User;
import static com.lubrindustrial.View.Home.escritorio;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Jhonny
 */
public class EquipmentTree extends javax.swing.JInternalFrame {

    /**
     * Creates new form DepartmentNew
     */
    
    ArrayList<Equipment> equipos = new ArrayList<>(); 
    ArrayList<DefaultMutableTreeNode> padres = new ArrayList<>();
    String host="";
    User user= new User();
    
    public EquipmentTree() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        cargarArbolEquipos();
    }
    
    public EquipmentTree(User us, String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        host=hostname;
        user=us;
        cargarArbolEquipos();
    }
    
    private void cargarArbolEquipos(){
        int indexPadre=0, distRaiz=0;
        EquipmentCRUD eqCRUD = new EquipmentCRUD(host);
        equipos = eqCRUD.visualizar(); // CARGO TODOS LOS EQUIPOS DE LA BD
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Árbol de Equipos"); // SE CARGA LA RAIZ DEL ARBOL
        
        // CARGO LOS EQUIPOS PADRES, ES DECIR LOS QUE TENGAN IDPADRE_EQ=0
        for(Equipment e: equipos){
            if(e.getIdPadreEq()==0){ // si esta en 0 es porque es padre
                DefaultMutableTreeNode nodoPadre = new DefaultMutableTreeNode(e.getNroEquipment()+" "+e.getDescEquipment());
                padres.add(nodoPadre); // lista de nodos padres para ir añadiendo los que se puedan anidar como sub padres
                raiz.add(nodoPadre);
            }
        }
        
        int cont=0;
        // CARGO LOS EQUIPOS HIJOS (NODO HIJO EN NODO PADRE)
        for(Equipment e: equipos){
            if(e.getIdPadreEq()!=0){ // es poque son hijos, los padres ya no son tomados en cuenta
                // tengo que buscar el padre de ese hijo
                indexPadre=buscarPadreHijo(e.getIdPadreEq(), e.getIdEquipment());
                DefaultMutableTreeNode padreAux = padres.get(indexPadre); // para averiguar en que nivel a la raiz se encuentra ese padre
                distRaiz = padreAux.getLevel();
//                System.out.println("Raiz= "+distRaiz);
                
                if(distRaiz==1){ // es poque es el nivel 1 de nodos
                    DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(e.getNroEquipment()+" "+e.getDescEquipment());
                    DefaultMutableTreeNode subPadre = padres.get(indexPadre);

                    subPadre.add(nodoHijo);
                }else{ // es porque el nivel de los nodos esta a partir de 1 es decir son sub nodos de nivel 1
                    indexPadre=buscarPadreHijo(e.getIdPadreEq(), e.getIdEquipment()); // encuentro al sub padre del padre ****
                    
                    DefaultMutableTreeNode SubNodoHijo = new DefaultMutableTreeNode(e.getNroEquipment()+" "+e.getDescEquipment());
                    DefaultMutableTreeNode subNodoPadre = padres.get(indexPadre);
                    
                    indexPadre=buscarPadreHijo(PadrePorID(e.getIdPadreEq()), e.getIdPadreEq()); // encuentro al padre ***
                    DefaultMutableTreeNode nodoPadre = padres.get(indexPadre);
                    
                    subNodoPadre.add(SubNodoHijo);
                    nodoPadre.add(subNodoPadre);
                    
//                    distRaiz = subNodoPadre.getLevel();
//                    System.out.println("raiz 2="+distRaiz);
                    
                }
                
//                cont++;
//                if(cont==4){
//                    System.out.println("Anide 4 nodos");
//                    break;
//                }
            }
        }
    
        // SETEO EL JTREE CON EL MODELO DEL ARBOL A GENERAR
        DefaultTreeModel treeModel = new DefaultTreeModel(raiz);
        jEquipmentsTree.setModel(treeModel);
    }
    
    private int indexEquipo(int id){
        int index=0;
        for(Equipment e: equipos){
            if(e.getIdEquipment()==id){
                break;
            }else{
                index++;
            }
        }
        
        return index;
           
    }
    
    private int PadrePorID(int id){
        int index=0;
        for(Equipment e: equipos){
            if(e.getIdEquipment()==id){
                index=e.getIdPadreEq();
                break;
            }
        }
        
        return index;
    }
    
    private int buscarPadreHijo(int padre, int id){
        int index=0;
        String cad="";
        for(Equipment e: equipos){
            if(e.getIdEquipment()==padre){
                cad=e.getNroEquipment()+" "+e.getDescEquipment();
            }
        }
        
        for(DefaultMutableTreeNode dft: padres){
//                System.out.println("Arbol: "+dft.toString());
//                System.out.println("cadena: "+cad);
            if(dft.toString().equals(cad)){
                DefaultMutableTreeNode nodoPadre = new DefaultMutableTreeNode(equipos.get(indexEquipo(id)).getNroEquipment()+" "+equipos.get(indexEquipo(id)).getDescEquipment());
                padres.add(nodoPadre);
                break;
            }else{
                index++;
            } 
        }
        
        return index;
    } 
    
    private void cargarArbol(){
        EquipmentCRUD eqCRUD = new EquipmentCRUD();
        equipos = eqCRUD.visualizar();
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Árbol de Equipos");
        //DefaultMutableTreeNode nodoPadre=null;
        
        // cargo los nodos iniciales que vienen a ser los padres
        
        for(Equipment e : equipos){ // averiguo quienes son padres
            if(e.getIdPadreEq()==0){ // es porque son padres
                //padres.add(e.getNroEquipment()+" "+e.getDescEquipment());
                DefaultMutableTreeNode nodoPadre = new DefaultMutableTreeNode(e.getNroEquipment()+" "+e.getDescEquipment());
                //System.out.println(nodoPadre.toString());
                padres.add(nodoPadre);
                raiz.add(nodoPadre);
            }
        }
        
        int indexPadre=0;
        int cont=0;
        int distanciaRaiz=0;
        boolean flag=true;
        
        for(Equipment e : equipos){
            if(e.getIdPadreEq()!=0 ){ // es porque son hijos
                //padres.add(e.getNroEquipment()+" "+e.getDescEquipment());
                //DefaultMutableTreeNode nodoPadre = new DefaultMutableTreeNode(e.getNroEquipment()+" "+e.getDescEquipment());
                //System.out.println("Hijo: "+e.getIdPadreEq());
                indexPadre=buscarPadreHijo(e.getIdPadreEq(), e.getIdEquipment());
                //System.out.println("Padre: "+e.getIdPadreEq()+" Equipo: "+e.getIdEquipment());
                //System.out.println(""+(raiz.getChildCount()));
                DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(e.getNroEquipment()+" "+e.getDescEquipment());
                DefaultMutableTreeNode padreAux = padres.get(indexPadre);
                
                distanciaRaiz = padreAux.getLevel();
                //System.out.println("Distancia: "+distanciaRaiz);
                
                if(distanciaRaiz==0){
                    //flag=false;
                    DefaultMutableTreeNode SubNodoHijo = new DefaultMutableTreeNode(e.getNroEquipment()+" "+e.getDescEquipment());
                    DefaultMutableTreeNode SubPadreAux = padres.get(indexPadre);
                    SubPadreAux.add(SubNodoHijo);
                    
                    indexPadre=buscarPadreHijo(PadrePorID(e.getIdPadreEq()), e.getIdPadreEq());
                    padreAux = padres.get(indexPadre); //
                    
                    padreAux.add(SubPadreAux);
                    
                    
                }else{
                    padreAux.add(nodoHijo); 
                }
                
                cont++;
                //System.out.println("Tamaño de nodos padre: "+padres.size());
                
            }
        }
        
//        for(DefaultMutableTreeNode d : padres){
//            System.out.println(d.toString());
//        }
        
        // cargo los equipos padres (nodos principales)
        /*
        for(String p : padres){
            DefaultMutableTreeNode nodoPadre = new DefaultMutableTreeNode(p);
            raiz.add(nodoPadre);
        }*/
        
        /*DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode("Mi nodo1");
        raiz.add(nodo1);
        
        DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode("Mi nodo2");
        raiz.add(nodo2);
        
        DefaultMutableTreeNode nodo1_1 = new DefaultMutableTreeNode("Mi nodo1_1");
        nodo1.add(nodo1_1);
        
        DefaultMutableTreeNode nodo2_1 = new DefaultMutableTreeNode("Mi nodo2_1");
        nodo2.add(nodo2_1);*/
        
        DefaultTreeModel treeModel = new DefaultTreeModel(raiz);
        
        jEquipmentsTree.setModel(treeModel);
    }
    
    private void Volver(){
        Equipments obj = new Equipments(user,host);
        Home.escritorio.add(obj);
        obj.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = obj.getSize();
        obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        obj.show();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEquipmentsTree = new javax.swing.JTree();
        btnCancelar = new javax.swing.JButton();

        setTitle("Árbol Equipos");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(jEquipmentsTree);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 370));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Volver();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTree jEquipmentsTree;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
