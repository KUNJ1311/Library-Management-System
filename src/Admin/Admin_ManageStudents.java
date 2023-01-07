package Admin;

//import User.User_DBConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Admin_ManageStudents extends javax.swing.JFrame {
    Color mouseEnterColor = new Color(0,0,0);
    Color mouseEnterRed = new Color(255,0,0);
    Color mouseExitRed = new Color(255,51,51);
    Color mouseExitColor = new Color(51,51,51);
    Color mouseExitBlue = new Color(51,51,255);
    Color mouseEnterBlue = new Color(0,0,235);
    

    /**
     * Creates new form HomePage
     */
    String studentName,course,branch;
    Long studentId;
    DefaultTableModel model;
    public Admin_ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
//display data on table
    public void setStudentDetailsToTable()
    {
        try {
             Connection con = Admin_DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from student_details");
             
             while(rs.next()){
                 Long studentId = rs.getLong("student_id");
                 String studentName = rs.getString("name");
                 String course = rs.getString("course");
                 String branch = rs.getString("branch");
                 
                 Object[] obj = {studentId,studentName,course,branch};
                 //add row inside table
                 model = (DefaultTableModel)tbl_StudentsDetails.getModel();
                 model.addRow(obj);
                 
             }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
    
    
    

//search method
        public void search(String str){
            model = (DefaultTableModel) tbl_StudentsDetails.getModel();
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
            tbl_StudentsDetails.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter(str));
            
        }
        
    
    //to add student to student details to table 
    
    public boolean addStudent(){
        boolean isAdded = false;
        studentId = Long.valueOf(txt_studentid.getText());
        studentName = txt_studentname.getText();
        course = jCombo_coursename.getSelectedItem().toString();
        branch = jCombo_branch.getSelectedItem().toString();
        
        
        
        try {
            Connection con = Admin_DBConnection.getConnection();
            String sql = "insert into student_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setLong(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0)
            {
                isAdded = true;
                
            }
            else
            {
                isAdded = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
        
    }
    //to update student Details
    
    public boolean updateStudent(){
        boolean isUpdated = false;
        studentId = Long.valueOf(txt_studentid.getText());
        studentName = txt_studentname.getText();
        course = jCombo_coursename.getSelectedItem().toString();
        branch = jCombo_branch.getSelectedItem().toString();
        
        try {
            Connection con = Admin_DBConnection.getConnection();
            String sql = "update student_details set name = ?,course = ? ,branch = ? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setLong(4, studentId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
            {
                isUpdated = true;
            }
            else
            {
                isUpdated = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
    
    //to delete student details
    public boolean deleteStudent(){
        boolean isDeleted=false;
        studentId = Long.valueOf(txt_studentid.getText());
        try {
            Connection con =Admin_DBConnection.getConnection();
            String sql = "delete from student_details where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, studentId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
            {
                isDeleted = true;
            }
            else
            {
                isDeleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    
    
    
    
    //to clear table and display new fresh details
    public void cleartable()
    {
        DefaultTableModel model_ = (DefaultTableModel) tbl_StudentsDetails.getModel();
        model_.setRowCount(0);
        
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        jLabel15 = new javax.swing.JLabel();
        jCombo_branch = new javax.swing.JComboBox<>();
        txt_studentname = new app.bolivia.swing.JCTextField();
        jCombo_coursename = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_StudentsDetails = new rojerusan.RSTableMetro();
        txt_bookname = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelHomePage = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanelmanagebooks = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanelIssuebook = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanelreturnbook = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanelmanagestudents = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanelbookrecord = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanellogout = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanelviewissuedbooks = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanelDefaulterList1 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanelLMS = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(5, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/admin.png"))); // NOI18N
        jLabel2.setText(" Welcome, Admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 0, 270, 70));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 70));

        jLabel25.setFont(new java.awt.Font("Imprint MT Shadow", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/exit.png"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1485, 0, 50, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 70));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        jPanel12.setPreferredSize(new java.awt.Dimension(550, 800));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel17.setText("Student Name:");
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 140, 30));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txt_studentid.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_studentid.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        txt_studentid.setPlaceholder("Enter Student ID.....");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        jPanel12.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 350, 40));

        jLabel18.setBackground(new java.awt.Color(102, 102, 255));
        jLabel18.setForeground(new java.awt.Color(102, 102, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/member.png"))); // NOI18N
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 50, 40));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel19.setText("Student ID:");
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, 30));

        jLabel13.setBackground(new java.awt.Color(102, 102, 255));
        jLabel13.setForeground(new java.awt.Color(102, 102, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/online-learning.png"))); // NOI18N
        jPanel12.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 50, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel11.setText("Select Branch:");
        jPanel12.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 130, 30));

        jLabel14.setBackground(new java.awt.Color(102, 102, 255));
        jLabel14.setForeground(new java.awt.Color(102, 102, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/branch.png"))); // NOI18N
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 50, 50));

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle5.setText("DELETE");
        rSMaterialButtonRectangle5.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        rSMaterialButtonRectangle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle5ActionPerformed(evt);
            }
        });
        jPanel12.add(rSMaterialButtonRectangle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 170, 120, -1));

        rSMaterialButtonRectangle6.setBackground(new java.awt.Color(255, 102, 0));
        rSMaterialButtonRectangle6.setText("UPDATE");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        rSMaterialButtonRectangle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle6ActionPerformed(evt);
            }
        });
        jPanel12.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 90, 120, -1));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(51, 51, 255));
        rSMaterialButtonRectangle2.setText("ADD");
        rSMaterialButtonRectangle2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel12.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 120, -1));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel15.setText("Select Course:");
        jPanel12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 130, 30));

        jCombo_branch.setFont(new java.awt.Font("Book Antiqua", 0, 17)); // NOI18N
        jCombo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "ME", "CBE", "IT", "Microbiology", "Chemistry" }));
        jCombo_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCombo_branchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCombo_branchMouseExited(evt);
            }
        });
        jPanel12.add(jCombo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 350, 40));

        txt_studentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txt_studentname.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_studentname.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        txt_studentname.setPlaceholder("Enter Student Name:.....");
        txt_studentname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentnameFocusLost(evt);
            }
        });
        txt_studentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentnameActionPerformed(evt);
            }
        });
        jPanel12.add(txt_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 350, 40));

        jCombo_coursename.setFont(new java.awt.Font("Book Antiqua", 0, 17)); // NOI18N
        jCombo_coursename.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.Tech", "B.Sc", "M.Sc", "Ph.D" }));
        jCombo_coursename.setToolTipText("");
        jCombo_coursename.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCombo_coursename.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCombo_coursenameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCombo_coursenameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCombo_coursenameMouseExited(evt);
            }
        });
        jPanel12.add(jCombo_coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 350, 40));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/add.png"))); // NOI18N
        jPanel12.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, -1, 50));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/update.png"))); // NOI18N
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, -1, 50));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/delete.png"))); // NOI18N
        jPanel12.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, -1, 50));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/search.png"))); // NOI18N
        jPanel12.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 50));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/user.png"))); // NOI18N
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 50, -1));

        jPanel7.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 250));

        tbl_StudentsDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Course", "Branch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_StudentsDetails.setColorBackgoundHead(new java.awt.Color(51, 51, 255));
        tbl_StudentsDetails.setColorBordeFilas(new java.awt.Color(51, 51, 51));
        tbl_StudentsDetails.setColorBordeHead(new java.awt.Color(51, 51, 51));
        tbl_StudentsDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_StudentsDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_StudentsDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_StudentsDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_StudentsDetails.setFont(new java.awt.Font("Century Schoolbook", 0, 24)); // NOI18N
        tbl_StudentsDetails.setFuenteFilas(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        tbl_StudentsDetails.setFuenteFilasSelect(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        tbl_StudentsDetails.setFuenteHead(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        tbl_StudentsDetails.setRowHeight(40);
        tbl_StudentsDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_StudentsDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_StudentsDetails);
        if (tbl_StudentsDetails.getColumnModel().getColumnCount() > 0) {
            tbl_StudentsDetails.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_StudentsDetails.getColumnModel().getColumn(1).setPreferredWidth(320);
            tbl_StudentsDetails.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbl_StudentsDetails.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1250, 470));

        txt_bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txt_bookname.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_bookname.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        txt_bookname.setPlaceholder("Enter Student ID/Name.....");
        txt_bookname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_booknameFocusLost(evt);
            }
        });
        txt_bookname.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txt_booknameCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txt_bookname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_booknameActionPerformed(evt);
            }
        });
        txt_bookname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_booknameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_booknameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_booknameKeyTyped(evt);
            }
        });
        jPanel7.add(txt_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 630, 40));

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel21.setText("Search ID/Name:");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 160, 30));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/search.png"))); // NOI18N
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 50));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 1270, 800));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHomePage.setBackground(new java.awt.Color(255, 51, 51));
        jPanelHomePage.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanelHomePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home40.png"))); // NOI18N
        jLabel6.setText("    Home Page");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        jPanelHomePage.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, -1));

        jPanel2.add(jPanelHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 270, -1));

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Features");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 250, -1));

        jPanelmanagebooks.setBackground(new java.awt.Color(51, 51, 51));
        jPanelmanagebooks.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanelmanagebooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open-book40.png"))); // NOI18N
        jLabel9.setText("   Manage Books");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanelmanagebooks.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 40));

        jPanel2.add(jPanelmanagebooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 270, -1));

        jPanelIssuebook.setBackground(new java.awt.Color(51, 51, 51));
        jPanelIssuebook.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanelIssuebook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/notebook40.png"))); // NOI18N
        jLabel10.setText("   Issue Book");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanelIssuebook.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, -1));

        jPanel2.add(jPanelIssuebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 270, -1));

        jPanelreturnbook.setBackground(new java.awt.Color(51, 51, 51));
        jPanelreturnbook.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanelreturnbook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return40.png"))); // NOI18N
        jLabel8.setText("   Return Book");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanelreturnbook.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, -1));

        jPanel2.add(jPanelreturnbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 270, -1));

        jPanelmanagestudents.setBackground(new java.awt.Color(51, 51, 51));
        jPanelmanagestudents.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanelmanagestudents.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graduated40.png"))); // NOI18N
        jLabel26.setText("   Manage Students");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });
        jPanelmanagestudents.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, -1));

        jPanel2.add(jPanelmanagestudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 270, -1));

        jPanelbookrecord.setBackground(new java.awt.Color(51, 51, 51));
        jPanelbookrecord.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanelbookrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/bookshelf40.png"))); // NOI18N
        jLabel20.setText("   Book Records");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });
        jPanelbookrecord.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, -1));

        jPanel2.add(jPanelbookrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 270, -1));

        jPanellogout.setBackground(new java.awt.Color(51, 51, 255));
        jPanellogout.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanellogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout40.png"))); // NOI18N
        jLabel12.setText("   Logout");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanellogout.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, -1));

        jPanel2.add(jPanellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 270, -1));

        jPanelviewissuedbooks.setBackground(new java.awt.Color(51, 51, 51));
        jPanelviewissuedbooks.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanelviewissuedbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelviewissuedbooksMouseClicked(evt);
            }
        });
        jPanelviewissuedbooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/bookfind40.png"))); // NOI18N
        jLabel29.setText("   View Issued Books");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });
        jPanelviewissuedbooks.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, -1));

        jPanel2.add(jPanelviewissuedbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 270, -1));

        jPanelDefaulterList1.setBackground(new java.awt.Color(51, 51, 51));
        jPanelDefaulterList1.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanelDefaulterList1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/due-date40.png"))); // NOI18N
        jLabel46.setText("   Defaulter List");
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel46MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel46MouseExited(evt);
            }
        });
        jPanelDefaulterList1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, -1));

        jPanel2.add(jPanelDefaulterList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 270, -1));

        jPanelLMS.setBackground(new java.awt.Color(51, 51, 51));
        jPanelLMS.setPreferredSize(new java.awt.Dimension(340, 60));
        jPanelLMS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/monitor40.png"))); // NOI18N
        jLabel5.setText("   LMS Dashboard");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanelLMS.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, -1));

        jPanel2.add(jPanelLMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 270, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 270, 960));

        setSize(new java.awt.Dimension(1535, 870));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        if(addStudent() == true)
        {
            ImageIcon icon = new ImageIcon(Admin_ManageStudents.class.getResource("/test/checked.png"));
            JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:green\">Student Added Successfully</b></html>","Message",JOptionPane.PLAIN_MESSAGE,icon);
            cleartable();
            setStudentDetailsToTable();
        }
        else
        {
            ImageIcon icon = new ImageIcon(Admin_ManageStudents.class.getResource("/test/error.png"));
            JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:red\">Student Addition Failed</b></html>","Message",JOptionPane.PLAIN_MESSAGE,icon);
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void rSMaterialButtonRectangle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle5ActionPerformed
        // TODO add your handling code here:
        if(deleteStudent()== true)
        {
            ImageIcon icon = new ImageIcon(Admin_ManageStudents.class.getResource("/test/checked.png"));
            JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:green\">Student Deleted Successfully</b></html>","Message",JOptionPane.PLAIN_MESSAGE,icon);
            cleartable();
            setStudentDetailsToTable();
        }
        else
        {
            ImageIcon icon = new ImageIcon(Admin_ManageStudents.class.getResource("/test/error.png"));
            JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:red\">Student Deletion Failed</b></html>","Message",JOptionPane.PLAIN_MESSAGE,icon);
        }
        
    }//GEN-LAST:event_rSMaterialButtonRectangle5ActionPerformed

    private void rSMaterialButtonRectangle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle6ActionPerformed
        // TODO add your handling code here:
        
        if(updateStudent()== true)
        {
            ImageIcon icon = new ImageIcon(Admin_ManageStudents.class.getResource("/test/checked.png"));
            JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:green\">Student Updated Successfully</b></html>","Message",JOptionPane.PLAIN_MESSAGE,icon);
            cleartable();
            setStudentDetailsToTable();
        }
        else
        {
            ImageIcon icon = new ImageIcon(Admin_ManageStudents.class.getResource("/test/error.png"));
            JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:red\">Student Updation Failed</b></html>","Message",JOptionPane.PLAIN_MESSAGE,icon);
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle6ActionPerformed

    private void tbl_StudentsDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_StudentsDetailsMouseClicked
        // TODO add your handling code here:
        
      
        int rowno = tbl_StudentsDetails.getSelectedRow();
        TableModel model_ = tbl_StudentsDetails.getModel();
        
        txt_studentid.setText(model_.getValueAt(rowno,0).toString());
        txt_studentname.setText(model_.getValueAt(rowno,1).toString());
        jCombo_coursename.setSelectedItem(model.getValueAt(rowno, 2).toString());
        jCombo_branch.setSelectedItem(model.getValueAt(rowno, 3).toString());
        
        
    }//GEN-LAST:event_tbl_StudentsDetailsMouseClicked

    private void txt_studentnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameFocusLost

    private void txt_studentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameActionPerformed

    private void jCombo_coursenameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCombo_coursenameMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jCombo_coursenameMouseClicked

    private void jCombo_coursenameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCombo_coursenameMouseEntered
        // TODO add your handling code here:
        //jCombo_coursename.showPopup();
    }//GEN-LAST:event_jCombo_coursenameMouseEntered

    private void jCombo_coursenameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCombo_coursenameMouseExited
        // TODO add your handling code here:
        //jCombo_coursename.hidePopup();
    }//GEN-LAST:event_jCombo_coursenameMouseExited

    private void jCombo_branchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCombo_branchMouseEntered
        // TODO add your handling code here:
        //jCombo_branch.showPopup();
    }//GEN-LAST:event_jCombo_branchMouseEntered

    private void jCombo_branchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCombo_branchMouseExited
        // TODO add your handling code here:
        //jCombo_branch.hidePopup();
    }//GEN-LAST:event_jCombo_branchMouseExited

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        Admin_HomePage homepage = new Admin_HomePage();
        homepage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
        jPanelHomePage.setBackground(mouseEnterRed);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // TODO add your handling code here:
        jPanelHomePage.setBackground(mouseExitRed);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Admin_ManageBooks books= new Admin_ManageBooks();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:

        jPanelmanagebooks.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jPanelmanagebooks.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        Admin_IssueBook issuebook = new Admin_IssueBook();
        issuebook.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
        jPanelIssuebook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
        jPanelIssuebook.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        jPanelreturnbook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:
        jPanelreturnbook.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        // TODO add your handling code here:
        jPanelmanagestudents.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited
        // TODO add your handling code here:
        jPanelmanagestudents.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel26MouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        Admin_ReturnBook returnbook = new Admin_ReturnBook();
        returnbook.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        Admin_ViewRecord viewrecord = new Admin_ViewRecord();
        viewrecord.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        // TODO add your handling code here:
        jPanelbookrecord.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        // TODO add your handling code here:
        jPanelbookrecord.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon(Admin_HomePage.class.getResource("/test/question.png"));
        int a = JOptionPane.showConfirmDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;color:red;\">Are You Sure You Want To Logout?</b></html>", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon);

        if (a == JOptionPane.YES_OPTION) {

            Admin_Login loginpage = new Admin_Login();
            loginpage.setVisible(true);
            dispose();
        }
        setDefaultCloseOperation(JOptionPane.NO_OPTION);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        // TODO add your handling code here:
        jPanellogout.setBackground(mouseEnterBlue);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
        jPanellogout.setBackground(mouseExitBlue);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        Admin_ViewIssuedBooks viewissuedbook = new Admin_ViewIssuedBooks();
        viewissuedbook.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        // TODO add your handling code here:
        jPanelviewissuedbooks.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        // TODO add your handling code here:
        jPanelviewissuedbooks.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel29MouseExited

    private void jPanelviewissuedbooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelviewissuedbooksMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelviewissuedbooksMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Admin_LMSDashboard lms = new Admin_LMSDashboard();
        lms.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        jPanelLMS.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        jPanelLMS.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel5MouseExited

    private void txt_booknameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_booknameFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_booknameFocusLost

    private void txt_booknameCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_booknameCaretPositionChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_booknameCaretPositionChanged

    private void txt_booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_booknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_booknameActionPerformed

    private void txt_booknameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_booknameKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_booknameKeyPressed

    private void txt_booknameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_booknameKeyReleased
        // TODO add your handling code here:
        String searchString = txt_bookname.getText();
        search(searchString);
    }//GEN-LAST:event_txt_booknameKeyReleased

    private void txt_booknameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_booknameKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_booknameKeyTyped

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
        Admin_DefaulterList list = new Admin_DefaulterList();
        list.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel46MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseEntered
        // TODO add your handling code here:
        jPanelDefaulterList1.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel46MouseEntered

    private void jLabel46MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseExited
        // TODO add your handling code here:
        jPanelDefaulterList1.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel46MouseExited

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCombo_branch;
    private javax.swing.JComboBox<String> jCombo_coursename;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelDefaulterList1;
    private javax.swing.JPanel jPanelHomePage;
    private javax.swing.JPanel jPanelIssuebook;
    private javax.swing.JPanel jPanelLMS;
    private javax.swing.JPanel jPanelbookrecord;
    private javax.swing.JPanel jPanellogout;
    private javax.swing.JPanel jPanelmanagebooks;
    private javax.swing.JPanel jPanelmanagestudents;
    private javax.swing.JPanel jPanelreturnbook;
    private javax.swing.JPanel jPanelviewissuedbooks;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSTableMetro tbl_StudentsDetails;
    private app.bolivia.swing.JCTextField txt_bookname;
    private app.bolivia.swing.JCTextField txt_studentid;
    private app.bolivia.swing.JCTextField txt_studentname;
    // End of variables declaration//GEN-END:variables
}
