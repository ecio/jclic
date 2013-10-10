/*
 * File    : ProjectInstallerDlg.java
 * Created : 04-jun-2002 09:55
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

import edu.xtec.jclic.activities.panels.*;
import edu.xtec.jclic.edit.EditorTreePanel;
import edu.xtec.jclic.fileSystem.FileBackup;
import edu.xtec.jclic.fileSystem.FileSystem;
import edu.xtec.jclic.misc.Gradient;
import edu.xtec.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.08.08
 */
public class ProjectInstallerDlg extends ExtendedJDialog implements ProgressInputStream.ProgressInputStreamListener, ListSelectionListener {
    
    public ProjectLibrary result;
    public boolean cancel;
    public boolean launchNow;
    public String pathToMainProject;
    
    Messages msg;
    LibraryManager lm;
    FileSystem storeFileSystem;
    ProjectInstaller pi;
    
    ProjectLibrary pl;
    LibraryManager.LibraryPane libraryPane;
    EditorTreePanel etp;
    File installDir;
    Options options;
    boolean workerRunning;
    edu.xtec.util.SwingWorker worker;
    boolean copyComplete;
    private Font titleFont, mainFont, itemFont;
    private Image logo;
    private Gradient logoGp;
    
    private int currentStage=0;
    private static final int STAGE_INFO=0, STAGE_SELECT_LIB=1, STAGE_COPY_FILES=2, STAGE_SELECT_FOLDER=3, STAGE_END=4, NUM_STAGES=5;
    private static final String[] STAGE_TITLES=new String[]{
        "install_title",
        "install_step_1",
        "install_step_2",
        "install_step_3",
        "install_step_4",
    };
    private static final String LOGO="icons/install.png";
    /** Creates new form ProjectInstallerDlg */
    private ProjectInstallerDlg(Component parent, LibraryManager lm, ProjectInstaller pi) throws Exception {
        super(parent, null, true);
        this.lm=lm;
        
        options=lm.settings.rb.getOptions();
        msg=options.getMessages();
        setTitle(msg.get("install_title"));
        result=null;
        launchNow=true;
        pathToMainProject=null;
        cancel=false;
        titleFont=new Font("Dialog", Font.BOLD, 18);
        mainFont=new Font("Dialog", Font.BOLD, 12);
        itemFont=new Font("Dialog", 0, 12);
        
        this.pi=pi;
        if(pi.from==null)
            throw new Exception("Path to installer data store not specified!");
        storeFileSystem=FileSystem.createFileSystem(pi.from, null, lm.settings.rb);
        logo=ResourceManager.getImageIcon(LOGO).getImage();
        logoGp=new Gradient(Color.white, Color.blue, 90, 1);
        initComponents();
        centerOver(parent);
        getRootPane().setDefaultButton(nextBtn);
    }
    
    public static ProjectInstallerDlg getProjectInstallerDlg(Component parent, LibraryManager lm, String installerScriptFile) throws Exception{
        return new ProjectInstallerDlg(parent, lm, ProjectInstaller.getProjectInstaller(installerScriptFile));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        javax.swing.JTextArea authorLb;
        javax.swing.JPanel basicPane;
        javax.swing.JPanel btPane;
        javax.swing.JLabel destLbHeader;
        javax.swing.JLabel finishLb;
        javax.swing.JLabel finishLb2;
        javax.swing.JLabel finishLb3;
        java.awt.GridBagConstraints gridBagConstraints;
        javax.swing.JLabel infoTitleLb;
        javax.swing.JLabel libFolderLb;
        javax.swing.JLabel libLb;
        javax.swing.JLabel sourceLb;
        javax.swing.JLabel sourceLbHeader;
        javax.swing.JLabel sourcePathLb;
        javax.swing.JLabel sourcePathLbHeader;
        javax.swing.JLabel statusLbHeader;
        javax.swing.JTextArea titleLb2;
        javax.swing.JLabel wizardInfoLb;

        btPane = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        prevBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        basicPane = new javax.swing.JPanel();
        mainPane = new javax.swing.JPanel();
        card00 = new javax.swing.JPanel();
        infoTitleLb = new javax.swing.JLabel();
        titleLb2 = new javax.swing.JTextArea();
        authorLb = new javax.swing.JTextArea();
        sourceLbHeader = new javax.swing.JLabel();
        sourceLb = new javax.swing.JLabel();
        wizardInfoLb = new javax.swing.JLabel();
        card01 = new javax.swing.JPanel();
        libLb = new javax.swing.JLabel();
        selectLibPanel = lm.getLibraryPane(true, true);
        libraryPane=(LibraryManager.LibraryPane)selectLibPanel;
        libraryPane.addListSelectionListener(this);
        card02 = new javax.swing.JPanel();
        sourcePathLbHeader = new javax.swing.JLabel();
        sourcePathLb = new javax.swing.JLabel();
        destLbHeader = new javax.swing.JLabel();
        destLb = new javax.swing.JLabel();
        statusLbHeader = new javax.swing.JLabel();
        statusLb = new javax.swing.JLabel();
        itemProgressBar = new javax.swing.JProgressBar();
        card03 = new javax.swing.JPanel();
        libFolderLb = new javax.swing.JLabel();
        libFolderPanel = new javax.swing.JPanel();
        card04 = new javax.swing.JPanel();
        finishLb = new javax.swing.JLabel();
        finishLb2 = new javax.swing.JLabel();
        finishLb3 = new javax.swing.JLabel();
        launchProjectChk = new javax.swing.JCheckBox();
        cardTitleLb = new javax.swing.JLabel();
        logoPanel = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                Rectangle r=new Rectangle(0, 0, getBounds().width, getBounds().height);
                if(logoGp!=null)
                logoGp.paint((Graphics2D)g, r);
                if(logo!=null){
                    int x=(r.width-logo.getWidth(this))/2;
                    int y=(r.height-logo.getHeight(this))/2;
                    g.drawImage(logo, x, y, this);
                }
            }
        };

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btPane.setLayout(new java.awt.GridBagLayout());

        cancelBtn.setToolTipText(msg.get("wizard_cancel_tooltip"));
        cancelBtn.setText(msg.get("wizard_cancel"));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        btPane.add(cancelBtn, gridBagConstraints);

        prevBtn.setToolTipText(msg.get("wizard_prev_tooltip"));
        prevBtn.setText(msg.get("wizard_prev"));
        prevBtn.setEnabled(false);
        prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtnActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        btPane.add(prevBtn, gridBagConstraints);

        nextBtn.setToolTipText(msg.get("wizard_next_tooltip"));
        nextBtn.setText(msg.get("wizard_next"));
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        btPane.add(nextBtn, gridBagConstraints);

        getContentPane().add(btPane, java.awt.BorderLayout.SOUTH);

        basicPane.setLayout(new java.awt.BorderLayout());

        basicPane.setPreferredSize(new java.awt.Dimension(500, 300));
        mainPane.setLayout(new java.awt.CardLayout());

        mainPane.setBackground(new java.awt.Color(255, 255, 204));
        card00.setLayout(new java.awt.GridBagLayout());

        card00.setOpaque(false);
        infoTitleLb.setFont(mainFont);
        infoTitleLb.setText(msg.get("install_info_info"));
        infoTitleLb.setPreferredSize(new java.awt.Dimension(300, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card00.add(infoTitleLb, gridBagConstraints);

        titleLb2.setEditable(false);
        titleLb2.setFont(mainFont);
        titleLb2.setLineWrap(true);
        titleLb2.setText("\""+pi.projectTitle+"\"");
        titleLb2.setWrapStyleWord(true);
        titleLb2.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        card00.add(titleLb2, gridBagConstraints);

        authorLb.setEditable(false);
        authorLb.setFont(itemFont);
        authorLb.setLineWrap(true);
        authorLb.setText(pi.authors!=null ? pi.authors : "");
        authorLb.setWrapStyleWord(true);
        authorLb.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        card00.add(authorLb, gridBagConstraints);

        sourceLbHeader.setText(msg.get("install_info_from"));
        sourceLbHeader.setFont(mainFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 3, 3);
        card00.add(sourceLbHeader, gridBagConstraints);

        sourceLb.setText(storeFileSystem.getFullRoot());
        sourceLb.setFont(itemFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        card00.add(sourceLb, gridBagConstraints);

        wizardInfoLb.setText(msg.get("wizard_info"));
        wizardInfoLb.setFont(mainFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 3, 3);
        card00.add(wizardInfoLb, gridBagConstraints);

        mainPane.add(card00, "card00");

        card01.setLayout(new java.awt.GridBagLayout());

        card01.setOpaque(false);
        libLb.setText(msg.get("install_select_library"));
        libLb.setFont(mainFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card01.add(libLb, gridBagConstraints);

        selectLibPanel.setBorder(new javax.swing.border.TitledBorder(msg.get("library_caption")));
        selectLibPanel.setPreferredSize(new java.awt.Dimension(300, 200));
        selectLibPanel.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card01.add(selectLibPanel, gridBagConstraints);

        mainPane.add(card01, "card01");

        card02.setLayout(new java.awt.GridBagLayout());

        card02.setPreferredSize(new java.awt.Dimension(400, 300));
        card02.setOpaque(false);
        sourcePathLbHeader.setText(msg.get("install_source"));
        sourcePathLbHeader.setFont(mainFont);
        sourcePathLbHeader.setLabelFor(sourcePathLb);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card02.add(sourcePathLbHeader, gridBagConstraints);

        sourcePathLb.setText(storeFileSystem.getFullRoot());
        sourcePathLb.setFont(itemFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card02.add(sourcePathLb, gridBagConstraints);

        destLbHeader.setText(msg.get("install_dest"));
        destLbHeader.setFont(mainFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card02.add(destLbHeader, gridBagConstraints);

        destLb.setText(pi.baseFolder);
        destLb.setFont(itemFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card02.add(destLb, gridBagConstraints);

        statusLbHeader.setText(msg.get("install_status"));
        statusLbHeader.setFont(mainFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 6, 3);
        card02.add(statusLbHeader, gridBagConstraints);

        statusLb.setText(msg.get("install_msg_waiting"));
        statusLb.setFont(itemFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 6, 3);
        card02.add(statusLb, gridBagConstraints);

        itemProgressBar.setToolTipText(msg.get("install_progress_tooltip"));
        itemProgressBar.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card02.add(itemProgressBar, gridBagConstraints);

        mainPane.add(card02, "card02");

        card03.setLayout(new java.awt.GridBagLayout());

        card03.setOpaque(false);
        libFolderLb.setText(msg.get("install_select_folder"));
        libFolderLb.setFont(mainFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card03.add(libFolderLb, gridBagConstraints);

        libFolderPanel.setLayout(new java.awt.BorderLayout());

        libFolderPanel.setBorder(new javax.swing.border.TitledBorder(msg.get("install_library_folders")));
        libFolderPanel.setPreferredSize(new java.awt.Dimension(300, 200));
        libFolderPanel.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        card03.add(libFolderPanel, gridBagConstraints);

        mainPane.add(card03, "card03");

        card04.setLayout(new java.awt.GridBagLayout());

        card04.setOpaque(false);
        finishLb.setText(msg.get("install_success_1"));
        finishLb.setFont(mainFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 13, 3);
        card04.add(finishLb, gridBagConstraints);

        finishLb2.setText(msg.get("install_success_2"));
        finishLb2.setFont(mainFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        card04.add(finishLb2, gridBagConstraints);

        finishLb3.setText(msg.get("install_success_3"));
        finishLb3.setFont(mainFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        card04.add(finishLb3, gridBagConstraints);

        launchProjectChk.setSelected(true);
        launchProjectChk.setText(msg.get("install_launchProject"));
        launchProjectChk.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 3, 3, 3);
        card04.add(launchProjectChk, gridBagConstraints);

        mainPane.add(card04, "card04");

        basicPane.add(mainPane, java.awt.BorderLayout.CENTER);

        cardTitleLb.setText(msg.get("install_title"));
        cardTitleLb.setForeground(new java.awt.Color(255, 255, 255));
        cardTitleLb.setBackground(new java.awt.Color(255, 153, 51));
        cardTitleLb.setFont(new java.awt.Font("SansSerif", 1, 18));
        cardTitleLb.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 10, 5, 10)));
        cardTitleLb.setOpaque(true);
        basicPane.add(cardTitleLb, java.awt.BorderLayout.NORTH);

        getContentPane().add(basicPane, java.awt.BorderLayout.CENTER);

        logoPanel.setPreferredSize(new java.awt.Dimension(75, 230));
        getContentPane().add(logoPanel, java.awt.BorderLayout.WEST);

        pack();
    }//GEN-END:initComponents
    
    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        
        if(currentStage==STAGE_COPY_FILES && !copyComplete){
            //copyFiles();
            // do nothing
        }
        else
            goToStage(currentStage+1);
        
        
    }//GEN-LAST:event_nextBtnActionPerformed
    
    private void goToStage(int stage){
        if(stage>=0 && stage<=NUM_STAGES){
            boolean bNext=false, bPrev=false, bCancel=false;
            currentStage=stage;
            switch(currentStage){
                case STAGE_INFO:
                    bNext=true; bPrev=false; bCancel=true;
                    break;
                    
                case STAGE_SELECT_LIB:
                    bNext=(libraryPane.getCurrentSelected()!=null);
                    bPrev=true; bCancel=true;
                    break;
                    
                case STAGE_COPY_FILES:
                    initCopyStage();
                    //prev=true; next=true; cancel=true;
                    copyFiles();
                    bPrev=false; bNext=false; bCancel=true;
                    break;
                    
                case STAGE_SELECT_FOLDER:
                    bNext=(etp!=null && etp.currentItem!=null && etp.currentItem instanceof MenuEditor);
                    bPrev=false; bCancel=true;
                    break;
                    
                case STAGE_END:
                    initEndStage();
                    bNext=true; bPrev=false; bCancel=false;
                    break;
                    
                case NUM_STAGES:
                    result=pl;
                    launchNow=launchProjectChk.isSelected();
                    closeDialog(null);
                    return;
                    
            }
            
            StringBuilder nbs=new StringBuilder("wizard_").append(currentStage<NUM_STAGES-1 ? "next" : "finish");
            nextBtn.setText(msg.get(nbs.substring(0)));
            nextBtn.setToolTipText(msg.get(nbs.append("_tooltip").substring(0)));
            nextBtn.setEnabled(bNext);
            prevBtn.setEnabled(bPrev);
            cancelBtn.setEnabled(bCancel);
            
            if(currentStage<NUM_STAGES){
                java.awt.CardLayout cl=(java.awt.CardLayout)mainPane.getLayout();
                String s=Integer.toString(stage);
                if(s.length()==1)
                    s="0"+s;
                cl.show(mainPane, "card"+s);
                cardTitleLb.setText(msg.get(STAGE_TITLES[stage]));
            }
        }
    }
    
    private void initCopyStage(){
        LibraryManagerElement lme=libraryPane.getCurrentSelected();
        if(pl==null || !pl.getFullPath().equals(lme.path)){
            try{
                pl=ProjectLibrary.loadProjectLibrary(lme.path, lm.settings.rb);
                if(etp!=null)
                    libFolderPanel.remove(etp);
                etp=new EditorTreePanel(pl.getEditor(null), options, true, Menu.class){
                    @Override
                    protected void currentItemChanged(){
                        if(currentStage==STAGE_SELECT_FOLDER){
                            nextBtn.setEnabled(currentItem!=null && currentItem instanceof MenuEditor);
                        }
                        super.currentItemChanged();
                    }
                };
                etp.getTree().setSelectionRow(1);
                libFolderPanel.add(etp, BorderLayout.CENTER);
                card03.revalidate();
                File root=new File(pl.getFileSystem().getFullRoot());
                installDir=new File(root, pi.baseFolder);
                
                destLb.setText(installDir.getAbsolutePath());
            } catch(Exception ex){
                msg.showErrorWarning(this, "library_error_reading", ex);
                closeDialog(null);
            }
        }
    }
    
    private void initEndStage(){
        try{
            Menu menu=((MenuEditor)etp.currentItem).getMenu();
            for(int i=0; i<pi.iconItems.size() && !cancel; i++){
                ProjectInstaller.IconItem ii=(ProjectInstaller.IconItem)pi.iconItems.get(i);
                MenuElement me=new MenuElement();
                me.caption=ii.text;
                me.projectPath=pi.baseFolder+File.separator+ii.project;
                if(ii.icon!=null){
                    if(!ii.icon.startsWith("@"))
                        me.icon=pi.baseFolder+File.separator+ii.icon;
                    else
                        me.icon=ii.icon;
                }
                else
                    me.icon=MenuElement.DEFAULT_ICON;
                if(ii.description!=null){
                    me.description=ii.description;
                }
                menu.addMenuElement(me);
                if(pathToMainProject==null)
                    pathToMainProject=pl.getFileSystem().getFullFileNamePath(me.projectPath);
            }
            pl.activityBag.addActivity(menu);
            pl.save(null);
            launchProjectChk.setEnabled(pathToMainProject!=null);        
        }
        catch(Exception ex){
            msg.showErrorWarning(this, "library_error_creating_icons", ex);
            closeDialog(null);
        }        
    }
    
    
    private void prevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBtnActionPerformed
        
        goToStage(currentStage-1);
        
        
    }//GEN-LAST:event_prevBtnActionPerformed
    
    
    public void valueChanged(ListSelectionEvent ev){
        if(ev!=null && !ev.getValueIsAdjusting() && currentStage==STAGE_SELECT_LIB)
            nextBtn.setEnabled(libraryPane.getCurrentSelected()!=null);
    }
    
    private void copyFiles(){
        final String PAUSED="PAUSED", ERR="ERROR", OK="OK", CANCEL="CANCEL";
        final ProjectInstallerDlg cmp=ProjectInstallerDlg.this;
        
        // fer backup dels fitxers
        
        prevBtn.setEnabled(false);
        nextBtn.setEnabled(false);
        statusLb.setText(msg.get("install_msg_waiting"));
        
        worker=new edu.xtec.util.SwingWorker(){
            
            @Override
            public Object construct(){
                workerRunning=true;
                ArrayList<FileBackup> fileBackups=new ArrayList<FileBackup>();
                Exception ex=null;
                String srcFolder=FileSystem.stdFn(storeFileSystem.getFullFileNamePath(null));
                String destFolder=FileSystem.stdFn(installDir.getAbsolutePath());
                if(srcFolder.equalsIgnoreCase(destFolder)){                                        
                    itemProgressBar.setValue(itemProgressBar.getMaximum());
                    statusLb.setText(msg.get("install_toSourceFolder"));
                }
                else{
                    try{
                        if(msg.confirmOverwriteFile(cmp, installDir, "yn")!=Messages.YES)
                            return PAUSED;
                        boolean overwriteAll=false;
                        boolean overwriteNone=false;
                        for(int i=0; i<pi.files.size() && !cancel; i++){
                            String file=pi.getFile(i).replace('/', File.separatorChar);
                            File f=new File(installDir, file);
                            statusLb.setText(msg.get("install_msg_copying")+" "+file);                            
                            if(f.exists()){
                                if(overwriteNone)
                                    continue;
                                if(!overwriteAll){
                                    boolean next=false;
                                    switch(msg.confirmOverwriteFile(cmp, f, "yYnNc")){
                                        case Messages.YES_TO_ALL:
                                            overwriteAll=true;
                                        case Messages.YES:
                                            break;
                                        case Messages.NO_TO_ALL:
                                            overwriteNone=true;
                                        case Messages.NO:
                                            next=true;
                                            break;
                                        default:
                                            cancel=true;
                                            break;
                                    }
                                    if(next)
                                        continue;
                                    if(cancel)
                                        break;
                                }                                
                            }                            
                            //if(msg.confirmOverwriteFile(cmp, f, "yn")!=Messages.YES)
                            //    continue;
                            InputStream is=storeFileSystem.getInputStream(pi.getFile(i));
                            ProgressInputStream pis;
                            if(is instanceof ProgressInputStream)
                                pis=(ProgressInputStream)is;
                            else{
                                pis=new ProgressInputStream(is, -1, file);
                            }
                            pis.addProgressInputStreamListener(cmp);
                            fileBackups.add(new FileBackup(f));
                            StreamIO.writeStreamTo(pis, new FileOutputStream(f));
                            // only for debug
                            //cancel=!msg.showQuestionDlg(cmp, "CONFIRM", "CONFIRM");
                        }
                    } catch(Exception e){
                        ex=e;
                    }
                    
                    if(!fileBackups.isEmpty()){
                        statusLb.setText(msg.get("install_msg_cleanup"));
                        for(int i=fileBackups.size()-1; i>=0; i--){
                            FileBackup fb=(FileBackup)fileBackups.get(i);
                            if(cancel || ex!=null){
                                try{
                                    fb.rollback();
                                } catch(Exception e){
                                    msg.showErrorWarning(cmp, "FILE_ERR_RESTORING", fb.getFile().getAbsolutePath(), e, null);
                                }
                            }
                            else{
                                try{
                                    fb.cleanup();
                                } catch(Exception e){
                                    msg.showErrorWarning(cmp, "FILE_ERR_DELETING", fb.getBackup().getAbsolutePath(), e, null);
                                }
                            }
                        }
                    }
                }
                
                statusLb.setText(msg.get("install_msg_end"));
                
                if(ex!=null)
                    return ex;
                
                return cancel ? CANCEL : OK;
            }
            
            @Override
            public void finished(){
                
                Object result=get();
                
                workerRunning=false;
                worker=null;
                
                if(result!=null){
                    if(cancel){
                        msg.showAlert(cmp, "install_msg_cancel");
                        closeDialog(null);
                    }
                    else if(result instanceof Exception){
                        msg.showErrorWarning(cmp, "install_error", (Exception)result);
                        closeDialog(null);
                    }
                    else if(result.equals(PAUSED)){
                        statusLb.setText(msg.get("install_msg_waiting"));
                        prevBtn.setEnabled(true);
                        nextBtn.setEnabled(true);
                    }
                    else if(result.equals(OK)){
                        nextBtn.setEnabled(true);
                        copyComplete=true;
                        nextBtnActionPerformed(null);
                    }
                }
            }
        };
        
        worker.start();
    }
    
    
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        
        cancel=true;
        StreamIO.setCancel(true);
        if(!workerRunning){
            msg.showAlert(this, "install_msg_cancel");
            closeDialog(null);
        } else{
            worker.interrupt();
        }
        
    }//GEN-LAST:event_cancelBtnActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    public void setProgressMax(int max){
        itemProgressBar.setMaximum(max);
    }
    public void setProgressValue(int value){
        itemProgressBar.setValue(value);
    }
    public void startProgress(String name){
        itemProgressBar.setValue(0);
    }
    public void endProgress(){
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel card00;
    private javax.swing.JPanel card01;
    private javax.swing.JPanel card02;
    private javax.swing.JPanel card03;
    private javax.swing.JPanel card04;
    private javax.swing.JLabel cardTitleLb;
    private javax.swing.JLabel destLb;
    private javax.swing.JProgressBar itemProgressBar;
    private javax.swing.JCheckBox launchProjectChk;
    private javax.swing.JPanel libFolderPanel;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel mainPane;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton prevBtn;
    private javax.swing.JPanel selectLibPanel;
    private javax.swing.JLabel statusLb;
    // End of variables declaration//GEN-END:variables
    
}
