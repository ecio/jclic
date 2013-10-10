/*
 * File    : OperatorEditorPanel.java
 * Created : 08-mar-2004 09:49
 * By      : fbusquets
 *
 * JClic - Authoring and playing system for educational activities
 *
 * Copyright (C) 2000 - 2005 Francesc Busquets & Departament
 * d'Educacio de la Generalitat de Catalunya
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details (see the LICENSE file).
 */

package edu.xtec.jclic.automation.arith;

import edu.xtec.jclic.beans.TextListEditor;
import edu.xtec.util.Options;
import java.util.EventObject;
import java.util.StringTokenizer;
import javax.swing.JComboBox;

/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.08.09
 */
public class OperatorEditorPanel extends edu.xtec.util.CtrlPanel {
    
    protected static final Integer[] LIST_OF_VALUES=new Integer[Operator.LIMITS.length];
    static{
        for(int i=0; i<Operator.LIMITS.length; i++)
            LIST_OF_VALUES[i]=new Integer(Operator.LIMITS[i]);
    }
    
    Options options;
    
    /** Creates new form OperandEditorPanel */
    public OperatorEditorPanel(Options options) {
        this.options=options;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        javax.swing.JPanel decPanel;
        javax.swing.JLabel fromLb;
        java.awt.GridBagConstraints gridBagConstraints;
        javax.swing.JLabel toLb;
        javax.swing.JLabel withLb;

        decGrp = new javax.swing.ButtonGroup();
        rangePanel = new javax.swing.JPanel();
        fromLb = new javax.swing.JLabel();
        fromCombo = new JComboBox(LIST_OF_VALUES);
        toLb = new javax.swing.JLabel();
        toCombo = new JComboBox(LIST_OF_VALUES);
        withLb = new javax.swing.JLabel();
        opPanel = new javax.swing.JPanel();
        withZeroChk = new javax.swing.JCheckBox();
        withOneChk = new javax.swing.JCheckBox();
        withMinusOneChk = new javax.swing.JCheckBox();
        fromListChk = new javax.swing.JCheckBox();
        listTxt = new javax.swing.JTextField();
        decPanel = new javax.swing.JPanel();
        opDec0 = new javax.swing.JRadioButton();
        opDec1 = new javax.swing.JRadioButton();
        opDec2 = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        rangePanel.setLayout(new java.awt.GridBagLayout());

        fromLb.setLabelFor(fromCombo);
        fromLb.setText(options.getMsg("edit_arith_op_from"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        rangePanel.add(fromLb, gridBagConstraints);

        fromCombo.setToolTipText(options.getMsg("edit_arith_op_from_tooltip"));
        fromCombo.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        rangePanel.add(fromCombo, gridBagConstraints);

        toLb.setLabelFor(toCombo);
        toLb.setText(options.getMsg("edit_arith_op_to"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        rangePanel.add(toLb, gridBagConstraints);

        toCombo.setToolTipText(options.getMsg("edit_arith_op_to_tooltip"));
        toCombo.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        rangePanel.add(toCombo, gridBagConstraints);

        withLb.setText(options.getMsg("edit_arith_op_with"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        rangePanel.add(withLb, gridBagConstraints);

        withZeroChk.setText("0");
        withZeroChk.setToolTipText(options.getMsg("edit_arith_op_with_tooltip"));
        withZeroChk.addActionListener(this);
        opPanel.add(withZeroChk);

        withOneChk.setText("1");
        withOneChk.setToolTipText(options.getMsg("edit_arith_op_with_tooltip"));
        withOneChk.addActionListener(this);
        opPanel.add(withOneChk);

        withMinusOneChk.setText("-1");
        withMinusOneChk.setToolTipText(options.getMsg("edit_arith_op_with_tooltip"));
        withMinusOneChk.addActionListener(this);
        opPanel.add(withMinusOneChk);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        rangePanel.add(opPanel, gridBagConstraints);

        fromListChk.setText(options.getMsg("edit_arith_op_fromList"));
        fromListChk.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        rangePanel.add(fromListChk, gridBagConstraints);

        listTxt.getDocument().addDocumentListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        rangePanel.add(listTxt, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(rangePanel, gridBagConstraints);

        decPanel.setLayout(new java.awt.GridBagLayout());

        decPanel.setBorder(new javax.swing.border.TitledBorder(options.getMsg("edit_arith_op_decimals")));
        opDec0.setText(options.getMsg("edit_arith_op_dec0"));
        decGrp.add(opDec0);
        opDec0.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        decPanel.add(opDec0, gridBagConstraints);

        opDec1.setText(options.getMsg("edit_arith_op_dec1"));
        decGrp.add(opDec1);
        opDec1.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        decPanel.add(opDec1, gridBagConstraints);

        opDec2.setText(options.getMsg("edit_arith_op_dec2"));
        decGrp.add(opDec2);
        opDec2.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        decPanel.add(opDec2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(decPanel, gridBagConstraints);

    }//GEN-END:initComponents
    
    private TextListEditor buildNumList(){
        TextListEditor tle=new TextListEditor(){
            @Override
            protected Object editItem(Object currentValue, boolean newValue){
                Object result=super.editItem(currentValue, newValue);
                if(result!=null){
                    boolean ok=false;
                    try{
                        int v=Integer.parseInt(result.toString());
                        ok=Math.abs(v)<Operator.MAX_VALUE;
                    } catch(NumberFormatException ex){
                    }
                    if(!ok){
                        options.getMessages().showAlert(this, "BAD_NUMBER");
                        result=null;
                    }
                }
                return result;
            }
        };
        tle.setOptions(options);
        tle.setMaxItems(Operator.NUMLST);
        return tle;
    }
    
    public void setOperator(Operator op){
        setInitializing(true);
        fromCombo.setSelectedIndex(op.limInf);
        toCombo.setSelectedIndex(op.limSup);
        withZeroChk.setSelected(op.wZero);
        withOneChk.setSelected(op.wOne);
        withMinusOneChk.setSelected(op.wMinusOne);
        if(op.numDec==1)
            opDec1.setSelected(true);
        else if(op.numDec==2)
            opDec2.setSelected(true);
        else
            opDec0.setSelected(true);
        fromListChk.setSelected(op.fromList>0);
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<op.fromList; i++){
            sb.append(op.lst[i]).append(" ");
        }
        listTxt.setText(sb.substring(0).trim());
        checkEnabled();
        setInitializing(false);
        setModified(false);
    }
    
    public Operator getOperator(){
        Operator op=new Operator();
        op.limInf=fromCombo.getSelectedIndex();
        op.limSup=toCombo.getSelectedIndex();
        op.wZero=withZeroChk.isSelected();
        op.wOne=withOneChk.isSelected();
        op.wMinusOne=withMinusOneChk.isSelected();
        if(opDec1.isSelected())
            op.numDec=1;
        else if(opDec2.isSelected())
            op.numDec=2;
        else
            op.numDec=0;
        op.fromList=0;
        if(fromListChk.isSelected()){            
            StringTokenizer st=new StringTokenizer(listTxt.getText());
            String str="";
            boolean alerted=false;
            while(st.hasMoreTokens() && op.fromList<Operator.NUMLST){
                try{
                    op.lst[op.fromList]=Integer.parseInt(st.nextToken());
                    op.fromList++;
                } catch(NumberFormatException ex){
                    if(!alerted){
                        options.getMessages().showAlert(this, "BAD_NUMBER");
                        alerted=true;
                    }
                }
            }
        }
        return op;
    }
    
    protected void checkEnabled(){
        boolean fromList=fromListChk.isSelected();
        listTxt.setEnabled(fromList);
        fromCombo.setEnabled(!fromList);
        toCombo.setEnabled(!fromList);
        withZeroChk.setEnabled(!fromList);
        withOneChk.setEnabled(!fromList);
        withMinusOneChk.setEnabled(!fromList);
    }
    

    @Override
    public boolean eventPerformed(EventObject ev){
        checkEnabled();
        return ev!=null;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup decGrp;
    private javax.swing.JComboBox fromCombo;
    private javax.swing.JCheckBox fromListChk;
    private javax.swing.JTextField listTxt;
    private javax.swing.JRadioButton opDec0;
    private javax.swing.JRadioButton opDec1;
    private javax.swing.JRadioButton opDec2;
    private javax.swing.JPanel opPanel;
    private javax.swing.JPanel rangePanel;
    private javax.swing.JComboBox toCombo;
    private javax.swing.JCheckBox withMinusOneChk;
    private javax.swing.JCheckBox withOneChk;
    private javax.swing.JCheckBox withZeroChk;
    // End of variables declaration//GEN-END:variables
    
}
