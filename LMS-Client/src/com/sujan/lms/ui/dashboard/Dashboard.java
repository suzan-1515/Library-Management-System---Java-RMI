/* 
 * Copyright (C) 2018 Suzn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sujan.lms.ui.dashboard;

import com.sujan.lms.ui.BaseDashboard;
import com.sujan.lms.ui.home.HomePanel;
import com.sujan.lms.common.entity.user.UserInfo;
import com.sujan.lms.ui.book.BookPanel;
import com.sujan.lms.ui.member.MemberPanel;
import com.sujan.lms.ui.report.ReportPanel;
import com.sujan.lms.ui.user.UserPanel;
import com.sujan.lms.util.ComponentUtils;
import com.sujan.lms.common.util.Logy;

/**
 *
 * @author Suzn
 */
public final class Dashboard extends BaseDashboard {

    private HomePanel homePanel;
    private BookPanel bookPanel;
    private MemberPanel memberPanel;
    private UserPanel userPanel;
    private ReportPanel reportPanel;

    private final UserInfo userInfo;

    /**
     * Creates new form LibrarianDashboard
     *
     * @param userInfo
     */
    public Dashboard(UserInfo userInfo) {
        initComponents();
        setLocationRelativeTo(null);
        this.userInfo = userInfo;
        setupUserView(userInfo);
        Logy.d("Dashboard panel initialized");
        ComponentUtils.addToPanel(this.centerPanel, getHomePanel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rootPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        homeMenuButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bookMenuButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        memberMenuButton = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        staffMenuButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        reportMenuButton = new javax.swing.JButton();
        logoutButtonPanel = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APU - Library Information System");
        setExtendedState(6);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
        setMinimumSize(new java.awt.Dimension(720, 630));
        setPreferredSize(new java.awt.Dimension(720, 630));
        getContentPane().setLayout(new java.awt.CardLayout());

        rootPanel.setBackground(new java.awt.Color(214, 217, 223));
        rootPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(39, 26, 252));
        topPanel.setLayout(new java.awt.GridLayout(1, 1, 10, 10));

        titlePanel.setBackground(new java.awt.Color(39, 26, 252));
        titlePanel.setPreferredSize(new java.awt.Dimension(508, 145));
        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        jPanel2.setBackground(new java.awt.Color(39, 26, 252));
        jPanel2.setPreferredSize(new java.awt.Dimension(430, 135));

        jPanel1.setBackground(new java.awt.Color(39, 26, 252));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("APU");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Library Information System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        logo.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        titlePanel.add(jPanel2);

        topPanel.add(titlePanel);

        rootPanel.add(topPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(new java.awt.Color(255, 255, 255));
        centerPanel.setMinimumSize(new java.awt.Dimension(300, 10));
        centerPanel.setOpaque(false);
        centerPanel.setPreferredSize(new java.awt.Dimension(500, 10));
        centerPanel.setLayout(new java.awt.CardLayout());
        rootPanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        leftPanel.setBackground(new java.awt.Color(214, 217, 223));
        leftPanel.setMinimumSize(new java.awt.Dimension(150, 10));
        leftPanel.setPreferredSize(new java.awt.Dimension(180, 412));
        leftPanel.setLayout(new java.awt.CardLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setOpaque(false);

        jPanel8.setBackground(new java.awt.Color(249, 249, 249));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel5.setBackground(new java.awt.Color(153, 0, 153));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(136, 70));

        homeMenuButton.setBackground(new java.awt.Color(102, 102, 255));
        homeMenuButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        homeMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        homeMenuButton.setText("Home");
        homeMenuButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(255, 0, 0)));
        buttonGroup1.add(homeMenuButton);
        homeMenuButton.setContentAreaFilled(false);
        homeMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        homeMenuButton.setIconTextGap(10);
        homeMenuButton.setOpaque(true);
        homeMenuButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        homeMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home1x.png"))); // NOI18N
        homeMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMenuButton.setBorder(selectedDashboardMenuBorder);
                bookMenuButton.setBorder(defaultDashboardMenuBorder);
                memberMenuButton.setBorder(defaultDashboardMenuBorder);
                staffMenuButton.setBorder(defaultDashboardMenuBorder);
                reportMenuButton.setBorder(defaultDashboardMenuBorder);
                homeMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeMenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.add(jPanel5);

        jPanel3.setBackground(new java.awt.Color(102, 255, 102));
        jPanel3.setOpaque(false);

        bookMenuButton.setBackground(new java.awt.Color(102, 102, 255));
        bookMenuButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bookMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        bookMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book.png"))); // NOI18N
        bookMenuButton.setText("Book");
        bookMenuButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        buttonGroup1.add(bookMenuButton);
        bookMenuButton.setContentAreaFilled(false);
        bookMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookMenuButton.setIconTextGap(10);
        bookMenuButton.setMargin(new java.awt.Insets(2, 15, 2, 14));
        bookMenuButton.setOpaque(true);
        bookMenuButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book.png"))); // NOI18N
        bookMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book1x.png"))); // NOI18N
        bookMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookMenuButton.setBorder(selectedDashboardMenuBorder);
                memberMenuButton.setBorder(defaultDashboardMenuBorder);
                homeMenuButton.setBorder(defaultDashboardMenuBorder);
                staffMenuButton.setBorder(defaultDashboardMenuBorder);
                reportMenuButton.setBorder(defaultDashboardMenuBorder);
                bookMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(136, 70));

        memberMenuButton.setBackground(new java.awt.Color(102, 102, 255));
        memberMenuButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        memberMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        memberMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/member.png"))); // NOI18N
        memberMenuButton.setText("Member");
        memberMenuButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        buttonGroup1.add(memberMenuButton);
        memberMenuButton.setContentAreaFilled(false);
        memberMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        memberMenuButton.setIconTextGap(10);
        memberMenuButton.setOpaque(true);
        memberMenuButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/member.png"))); // NOI18N
        memberMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/member1x.png"))); // NOI18N
        memberMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberMenuButton.setBorder(selectedDashboardMenuBorder);
                bookMenuButton.setBorder(defaultDashboardMenuBorder);
                homeMenuButton.setBorder(defaultDashboardMenuBorder);
                staffMenuButton.setBorder(defaultDashboardMenuBorder);
                reportMenuButton.setBorder(defaultDashboardMenuBorder);
                memberMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(memberMenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memberMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.add(jPanel4);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(136, 70));

        staffMenuButton.setBackground(new java.awt.Color(102, 102, 255));
        staffMenuButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        staffMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        staffMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staff.png"))); // NOI18N
        staffMenuButton.setText("User");
        staffMenuButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        buttonGroup1.add(staffMenuButton);
        staffMenuButton.setContentAreaFilled(false);
        staffMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        staffMenuButton.setIconTextGap(10);
        staffMenuButton.setOpaque(true);
        staffMenuButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staff.png"))); // NOI18N
        staffMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staff1x.png"))); // NOI18N
        staffMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffMenuButton.setBorder(selectedDashboardMenuBorder);
                bookMenuButton.setBorder(defaultDashboardMenuBorder);
                homeMenuButton.setBorder(defaultDashboardMenuBorder);
                memberMenuButton.setBorder(defaultDashboardMenuBorder);
                reportMenuButton.setBorder(defaultDashboardMenuBorder);
                userMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffMenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setOpaque(false);
        jPanel10.setPreferredSize(new java.awt.Dimension(136, 70));

        reportMenuButton.setBackground(new java.awt.Color(102, 102, 255));
        reportMenuButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reportMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        reportMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        reportMenuButton.setText("Report");
        reportMenuButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        buttonGroup1.add(reportMenuButton);
        reportMenuButton.setContentAreaFilled(false);
        reportMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reportMenuButton.setIconTextGap(10);
        reportMenuButton.setOpaque(true);
        reportMenuButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        reportMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report1x.png"))); // NOI18N
        reportMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportMenuButton.setBorder(selectedDashboardMenuBorder);
                homeMenuButton.setBorder(defaultDashboardMenuBorder);
                bookMenuButton.setBorder(defaultDashboardMenuBorder);
                memberMenuButton.setBorder(defaultDashboardMenuBorder);
                staffMenuButton.setBorder(defaultDashboardMenuBorder);
                reportMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reportMenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.add(jPanel10);

        logoutButtonPanel.setBackground(new java.awt.Color(255, 255, 255));
        logoutButtonPanel.setOpaque(false);

        logoutButton.setBackground(new java.awt.Color(255, 82, 36));
        logoutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        logoutButton.setContentAreaFilled(false);
        logoutButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutButton.setIconTextGap(10);
        logoutButton.setOpaque(true);
        logoutButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logoutButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout1x.png"))); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout logoutButtonPanelLayout = new javax.swing.GroupLayout(logoutButtonPanel);
        logoutButtonPanel.setLayout(logoutButtonPanelLayout);
        logoutButtonPanelLayout.setHorizontalGroup(
            logoutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        logoutButtonPanelLayout.setVerticalGroup(
            logoutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(logoutButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        leftPanel.add(jPanel6, "card2");

        rootPanel.add(leftPanel, java.awt.BorderLayout.LINE_START);

        getContentPane().add(rootPanel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        GuestDashboard guestDashboard = new GuestDashboard();
        guestDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void homeMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Logy.d("Home menu clicked");
        ComponentUtils.addToPanel(this.centerPanel, getHomePanel());
    }

    private void bookMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Logy.d("Book menu clicked");
        ComponentUtils.addToPanel(this.centerPanel, getBookPanel());
    }

    private void transactionMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Logy.d("Transaction menu clicked");
        ComponentUtils.addToPanel(this.centerPanel, getTransactionPanel());
    }

    private void memberMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Logy.d("Member menu clicked");
        ComponentUtils.addToPanel(this.centerPanel, getMemberPanel());
    }

    private void userMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Logy.d("User menu clicked");
        ComponentUtils.addToPanel(this.centerPanel, getUserPanel());
    }

    private void reportMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Logy.d("Report menu clicked");
        ComponentUtils.addToPanel(this.centerPanel, getReportPanel());
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard(new UserInfo()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookMenuButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton homeMenuButton;
    private javax.swing.border.Border defaultDashboardMenuBorder = javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0);
    private javax.swing.border.Border selectedDashboardMenuBorder = javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(255, 0, 0));
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel logoutButtonPanel;
    private javax.swing.JButton memberMenuButton;
    private javax.swing.JButton reportMenuButton;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JButton staffMenuButton;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

    private BookPanel getBookPanel() {
        if (bookPanel == null) {
            Logy.d("Creating book panel instance");
            bookPanel = new BookPanel(userInfo);
        }

        return bookPanel;
    }

    private MemberPanel getMemberPanel() {
        if (memberPanel == null) {
            Logy.d("Creating member panel instance");
            memberPanel = new MemberPanel(userInfo);
        }

        return memberPanel;
    }

    private UserPanel getUserPanel() {
        if (userPanel == null) {
            Logy.d("Creating user panel instance");
            userPanel = new UserPanel(userInfo);
        }

        return userPanel;
    }

    private HomePanel getHomePanel() {
        if (homePanel == null) {
            Logy.d("Creating home panel instance");
            homePanel = new HomePanel(userInfo);
        }

        return homePanel;
    }

    private HomePanel getTransactionPanel() {
        if (homePanel == null) {
            Logy.d("Creating transaction panel instance");
            homePanel = new HomePanel(userInfo);
        }

        return homePanel;
    }

    private ReportPanel getReportPanel() {
        if (reportPanel == null) {
            Logy.d("Creating report panel instance");
            reportPanel = new ReportPanel(userInfo);
        }

        return reportPanel;
    }

    @Override
    protected void setupAdminView() {
    }

    @Override
    protected void setupLibrarianView() {
        staffMenuButton.setVisible(false);
        reportMenuButton.setVisible(false);
    }

    @Override
    protected void setupMemberView() {
        staffMenuButton.setVisible(false);
        reportMenuButton.setVisible(false);
        memberMenuButton.setVisible(false);
    }
}
