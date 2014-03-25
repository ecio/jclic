/*
 * File    : OrganizationEditPanel.java
 * Created : 27-feb-2004 17:13
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

package edu.xtec.jclic.project;

import edu.xtec.util.Options;
import edu.xtec.util.StrUtils;

/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.09.09
 */
public class OrganizationEditPanel extends javax.swing.JPanel {
    
    Options options;
    
    /** Creates new form AuthorEditPanel */
    public OrganizationEditPanel(Options options) {
        this.options=options;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        javax.swing.JLabel addressLb;
        javax.swing.JLabel cityLb;
        javax.swing.JLabel commentsLb;
        javax.swing.JScrollPane commentsScroll;
        javax.swing.JLabel countryLb;
        java.awt.GridBagConstraints gridBagConstraints;
        javax.swing.JLabel mailLb;
        javax.swing.JLabel nameLb;
        javax.swing.JLabel pcLb;
        javax.swing.JLabel stateLb;
        javax.swing.JLabel urlLb;

        nameLb = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        mailLb = new javax.swing.JLabel();
        mailText = new javax.swing.JTextField();
        urlLb = new javax.swing.JLabel();
        urlText = new javax.swing.JTextField();
        addressLb = new javax.swing.JLabel();
        addressText = new javax.swing.JTextField();
        pcLb = new javax.swing.JLabel();
        pcText = new javax.swing.JTextField();
        cityLb = new javax.swing.JLabel();
        cityText = new javax.swing.JTextField();
        stateLb = new javax.swing.JLabel();
        stateText = new javax.swing.JTextField();
        countryLb = new javax.swing.JLabel();
        countryText = new javax.swing.JTextField();
        commentsLb = new javax.swing.JLabel();
        commentsScroll = new javax.swing.JScrollPane();
        commentsText = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        nameLb.setLabelFor(nameText);
        nameLb.setText(options.getMsg("edit_project_org_name"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(nameLb, gridBagConstraints);

        nameText.setToolTipText(options.getMsg("edit_project_org_name_tooltip"));
        nameText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(nameText, gridBagConstraints);

        mailLb.setLabelFor(mailText);
        mailLb.setText(options.getMsg("edit_project_org_mail"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(mailLb, gridBagConstraints);

        mailText.setToolTipText(options.getMsg("edit_project_org_mail_tooltip"));
        mailText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(mailText, gridBagConstraints);

        urlLb.setLabelFor(urlText);
        urlLb.setText(options.getMsg("edit_project_org_url"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(urlLb, gridBagConstraints);

        urlText.setToolTipText(options.getMsg("edit_project_org_url_tooltip"));
        urlText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(urlText, gridBagConstraints);

        addressLb.setLabelFor(addressText);
        addressLb.setText(options.getMsg("edit_project_org_address"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(addressLb, gridBagConstraints);

        addressText.setToolTipText(options.getMsg("edit_project_org_address_tooltip"));
        addressText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(addressText, gridBagConstraints);

        pcLb.setLabelFor(pcText);
        pcLb.setText(options.getMsg("edit_project_org_pc"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(pcLb, gridBagConstraints);

        pcText.setToolTipText(options.getMsg("edit_project_org_pc_tooltip"));
        pcText.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(pcText, gridBagConstraints);

        cityLb.setLabelFor(cityText);
        cityLb.setText(options.getMsg("edit_project_org_city"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(cityLb, gridBagConstraints);

        cityText.setToolTipText(options.getMsg("edit_project_org_city_tooltip"));
        cityText.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(cityText, gridBagConstraints);

        stateLb.setLabelFor(stateText);
        stateLb.setText(options.getMsg("edit_project_org_state"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(stateLb, gridBagConstraints);

        stateText.setToolTipText(options.getMsg("edit_project_org_state_tooltip"));
        stateText.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(stateText, gridBagConstraints);

        countryLb.setLabelFor(countryText);
        countryLb.setText(options.getMsg("edit_project_org_country"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(countryLb, gridBagConstraints);

        countryText.setToolTipText(options.getMsg("edit_project_org_country_tooltip"));
        countryText.setPreferredSize(new java.awt.Dimension(100, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(countryText, gridBagConstraints);

        commentsLb.setLabelFor(commentsText);
        commentsLb.setText(options.getMsg("edit_project_org_comments"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(commentsLb, gridBagConstraints);

        commentsScroll.setPreferredSize(new java.awt.Dimension(300, 60));
        commentsText.setLineWrap(true);
        commentsText.setToolTipText(options.getMsg("edit_project_org_comments_tooltip"));
        commentsText.setWrapStyleWord(true);
        commentsScroll.setViewportView(commentsText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(commentsScroll, gridBagConstraints);

    }//GEN-END:initComponents

    
    public void setOrganization(Organization org){
        nameText.setText(org!=null ? org.name : "");
        mailText.setText(org!=null ? org.mail : "");
        urlText.setText(org!=null ? org.url : "");
        addressText.setText(org!=null ? org.address : "");
        pcText.setText(org!=null ? org.pc : "");
        cityText.setText(org!=null ? org.city : "");
        countryText.setText(org!=null ? org.country : "");
        stateText.setText(org!=null ? org.state : "");
        commentsText.setText(org!=null ? org.comments : "");
    }
    
    public Organization getOrganization(){
        Organization org=new Organization();
        org.name=nameText.getText().trim();
        org.mail=StrUtils.nullableString(mailText.getText().trim());
        org.url=StrUtils.nullableString(urlText.getText().trim());
        org.address=StrUtils.nullableString(addressText.getText().trim());
        org.pc=StrUtils.nullableString(pcText.getText().trim());
        org.city=StrUtils.nullableString(cityText.getText().trim());
        org.country=StrUtils.nullableString(countryText.getText().trim());
        org.state=StrUtils.nullableString(stateText.getText().trim());
        org.comments=StrUtils.nullableString(commentsText.getText().trim());
        return org;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressText;
    private javax.swing.JTextField cityText;
    private javax.swing.JTextArea commentsText;
    private javax.swing.JTextField countryText;
    private javax.swing.JTextField mailText;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField pcText;
    private javax.swing.JTextField stateText;
    private javax.swing.JTextField urlText;
    // End of variables declaration//GEN-END:variables
    
}