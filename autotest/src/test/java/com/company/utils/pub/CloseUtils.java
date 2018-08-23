package com.company.utils.pub;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class CloseUtils {
    //封装close
    public void closeConnection(Connection connection){
        if(connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void closeStatement(Statement stmt,PreparedStatement pstmt,CallableStatement cstmt){
        if(stmt!=null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(pstmt!=null){
            try{
                pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(cstmt!=null){
            try{
                cstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void closeResultSet(ResultSet resultSet){
        if(resultSet!=null){
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public void closeIO(FileInputStream fileInputStream,FileOutputStream fileOutputStream){
        if(fileInputStream!=null){
            try{
                fileInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        if(fileOutputStream!=null){
            try {
                fileOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();//关闭输出流
            }
        }

    }
    public void closeIO(FileInputStream fileInputStream){
        if(fileInputStream!=null){
            try{
                fileInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
    public void closeIO(FileOutputStream fileOutputStream){
        if(fileOutputStream!=null){
            try {
                fileOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();//关闭输出流
            }
        }
    }

    public void closeWorkbook(Workbook workbook){
        if (workbook!=null){
            try{
                workbook.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
