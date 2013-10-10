/*
 * File    : AuthorEditPanel.java
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
public class AuthorEditPanel extends javax.swing.JPanel {
    
    Options options;
    
    /** Creates new form AuthorEditPanel */
    public AuthorEditPanel(Options options) {
        this.options=options;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        javax.swing.JLabel commentsLb;
        javax.swing.JScrollPane commentsScroll;
        java.awt.GridBagConstraints gridBagConstraints;
        javax.swing.JLabel mailLb;
        javax.swing.JLabel nameLb;
        javax.swing.JLabel organizationLb;
        javax.swing.JLabel rolLb;
        javax.swing.JLabel urlLb;

        nameLb = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        rolLb = new javax.swing.JLabel();
        rolText = new javax.swing.JTextField();
        mailLb = new javax.swing.JLabel();
        mailText = new javax.swing.JTextField();
        urlLb = new javax.swing.JLabel();
        urlText = new javax.swing.JTextField();
        organizationLb = new javax.swing.JLabel();
        organizationText = new javax.swing.JTextField();
        commentsLb = new javax.swing.JLabel();
        commentsScroll = new javax.swing.JScrollPane();
        commentsText = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        nameLb.setLabelFor(nameText);
        nameLb.setText(options.getMsg("edit_project_author_name"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(nameLb, gridBagConstraints);

        nameText.setToolTipText(options.getMsg("edit_project_author_name_tooltip"));
        nameText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(nameText, gridBagConstraints);

        rolLb.setLabelFor(rolText);
        rolLb.setText(options.getMsg("edit_project_author_rol"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(rolLb, gridBagConstraints);

        rolText.setToolTipText(options.getMsg("edit_project_author_rol_tooltip"));
        rolText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(rolText, gridBagConstraints);

        mailLb.setLabelFor(mailText);
        mailLb.setText(options.getMsg("edit_project_author_mail"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(mailLb, gridBagConstraints);

        mailText.setToolTipText(options.getMsg("edit_project_author_mail_tooltip"));
        mailText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(mailText, gridBagConstraints);

        urlLb.setLabelFor(urlText);
        urlLb.setText(options.getMsg("edit_project_author_url"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(urlLb, gridBagConstraints);

        urlText.setToolTipText(options.getMsg("edit_project_author_url_tooltip"));
        urlText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(urlText, gridBagConstraints);

        organizationLb.setLabelFor(organizationText);
        organizationLb.setText(options.getMsg("edit_project_author_organization"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(organizationLb, gridBagConstraints);

        organizationText.setToolTipText(options.getMsg("edit_project_author_organization_tooltip"));
        organizationText.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(organizationText, gridBagConstraints);

        commentsLb.setLabelFor(commentsText);
        commentsLb.setText(options.getMsg("edit_project_author_comments"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(commentsLb, gridBagConstraints);

        commentsScroll.setPreferredSize(new java.awt.Dimension(300, 60));
        commentsText.setWrapStyleWord(true);
        commentsText.setToolTipText(options.getMsg("edit_project_author_comments_tooltip"));
        commentsText.setLineWrap(true);
        commentsScroll.setViewportView(commentsText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(commentsScroll, gridBagConstraints);

    }//GEN-END:initComponents

    
    public void setAuthor(Author author){
        nameText.setText(author!=null ? author.name : "");
        mailText.setText(author!=null ? author.mail : "");
        urlText.setText(author!=null ? author.url : "");
        organizationText.setText(author!=null ? author.organization : "");
        commentsText.setText(author!=null ? author.comments : "");
        rolText.setText(author!=null ? author.rol : "");
    }
    
    public Author getAuthor(){
        Author author=new Author();
        author.name=nameText.getText().trim();
        author.mail=StrUtils.nullableString(mailText.getText().trim());
        author.url=StrUtils.nullableString(urlText.getText().trim());
        author.organization=StrUtils.nullableString(organizationText.getText().trim());
        author.comments=StrUtils.nullableString(commentsText.getText().trim());
        author.rol=StrUtils.nullableString(rolText.getText().trim());        
        return author;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea commentsText;
    private javax.swing.JTextField mailText;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField organizationText;
    private javax.swing.JTextField rolText;
    private javax.swing.JTextField urlText;
    // End of variables declaration//GEN-END:variables
    
}
