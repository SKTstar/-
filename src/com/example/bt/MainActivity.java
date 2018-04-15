package com.example.bt;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

	

	//����ͨ������
	byte[] data=new byte[34];
	
	//����flag�����ڿ���ѭ������ͨ�����顣
	boolean flag=false;
	
	//����socket
	Socket socket;
	
	//����x34��������ʱ�������ֵ��
	int x34=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initdata();
		initseekbar1();
		initseekbar2();
		initseekbar3();
		initseekbar4();
		
	}
	
	
	/*
	 * ��ͨ��������ӳ�ʼ����
	 */
	public void initdata(){
		data[0]=(byte)0xAA;  	//Э��̶�ֵ
		data[1]=(byte)0xC0;		//Э��̶�ֵ
		data[2]=(byte)0x1C;		//Э��̶�ֵ
		//���ڿ������·�������ֵ��
		data[3]=(byte)0x00;
		data[4]=(byte)0x00;
		//���ڿ�����������������ֵ��
		data[5]=(byte)(1500>>8);
		data[6]=(byte)(1500&0xff);
		//���ڿ������ҷ��򣨺��ֵ��
		data[7]=(byte)(1500>>8);
		data[8]=(byte)(1500&0xff);
		//����ǰ���򣨸���ֵ��
		data[9]=(byte)(1500>>8);
		data[10]=(byte)(1500&0xff);
		
		data[31]=(byte)0x1C;	//Э��̶�ֵ
		data[32]=(byte)0x0D;	//Э��̶�ֵ
		data[33]=(byte)0x0A;	//Э��̶�ֵ
		
	}
	//��������
//	public void btnadd(View view){
//		//���ڿ������·�������ֵ��
//		data[3]=(byte)(300>>8);  //��100��Ϊ�߰�λ
//		data[4]=(byte)(300&0xff);  //��100��Ϊ�Ͱ�λ
//		new Thread(new senddata()).start();
//	}
	
	public void initseekbar1(){
		//�ҿؼ�
		SeekBar sb1=(SeekBar) findViewById(R.id.seekBar1);
		//�������ֵ
		sb1.setMax(1000);
		//���÷�������ȡ��ǰ��ֵ
		sb1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int i,
					boolean fromUser) {
				data[3]=(byte)(i>>8);  //�ѻ�ȡ��ֵ��Ϊ�߰�λ
				data[4]=(byte)(i&0xff);  //�ѻ�ȡ��ֵ��Ϊ�Ͱ�λ
				//new Thread(new senddata()).start();
				 //�ҿؼ�
				TextView tv=(TextView) findViewById(R.id.textView2);
				//������ֵ���ø��ؼ�
				tv.setText("����ֵ��"+i+"");
				
			}
		});
	}
	
	public void initseekbar2(){
		//�ҿؼ�
		SeekBar sb2=(SeekBar) findViewById(R.id.seekBar2);
		//�������ֵ
		sb2.setMax(3000);
		//����Ĭ��ֵ
		sb2.setProgress(1500);
		//���÷�������ȡ��ǰ��ֵ
		sb2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int i,
					boolean fromUser) {
				data[5]=(byte)(i>>8);  //�ѻ�ȡ��ֵ��Ϊ�߰�λ
				data[6]=(byte)(i&0xff);  //�ѻ�ȡ��ֵ��Ϊ�Ͱ�λ
				//new Thread(new senddata()).start();
				 //�ҿؼ�
				TextView tv=(TextView) findViewById(R.id.textView3);
				//�Ѻ���ֵ���ø��ؼ�
				tv.setText("����ֵ��"+i+"");
				
			}
		});
	}
	
	
	
	
	public void initseekbar3(){
		//�ҿؼ�
		SeekBar sb3=(SeekBar) findViewById(R.id.seekBar3);
		//�������ֵ
		sb3.setMax(3000);
		//����Ĭ��ֵ
		sb3.setProgress(1500);
		//���÷�������ȡ��ǰ��ֵ
		sb3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int i,
					boolean fromUser) {
				data[7]=(byte)(i>>8);  //�ѻ�ȡ��ֵ��Ϊ�߰�λ
				data[8]=(byte)(i&0xff);  //�ѻ�ȡ��ֵ��Ϊ�Ͱ�λ
				//new Thread(new senddata()).start();
				 //�ҿؼ�
				TextView tv=(TextView) findViewById(R.id.textView4);
				//�Ѻ��ֵ���ø��ؼ�
				tv.setText("���ֵ��"+i+"");
				
			}
		});
	}
	public void initseekbar4(){
		//�ҿؼ�
		SeekBar sb4=(SeekBar) findViewById(R.id.seekBar4);
		//�������ֵ
		sb4.setMax(3000);
		//����Ĭ��ֵ
		sb4.setProgress(1500);
		//���÷�������ȡ��ǰ��ֵ
		sb4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int i,
					boolean fromUser) {
				data[9]=(byte)(i>>8);  //�ѻ�ȡ��ֵ��Ϊ�߰�λ
				data[10]=(byte)(i&0xff);  //�ѻ�ȡ��ֵ��Ϊ�Ͱ�λ
				//new Thread(new senddata()).start();
				 //�ҿؼ�
				TextView tv=(TextView) findViewById(R.id.textView5);
				//�Ѹ���ֵ���ø��ؼ�
				tv.setText("����ֵ��"+i+"");
				
			}
		});
	}
	
	
	
	/**
	 * ���߳������ã�����ͨ����������˻�
	 */
	public class senddata implements Runnable{

		@Override
		public void run() {
			OutputStream out;
			try {
				out =socket.getOutputStream();	//���������
				while(flag){
					out.write(data); //����ͨ������
					Thread.sleep(5); //ÿ����뷢��һ��
				}
			} catch (IOException e) {	
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
	}

	/*
	 * �ڶ��������߳�
	 */
	public class ClientThread implements Runnable{

		@Override
		public void run() {
			//���������߳���ͨ��
			
			try {
				//3.1 ����socket�����ӷ��ʵ�IP��ַ�Ͷ˿ں�
				 socket=new Socket("192.168.4.1",333);
				//3.2�����������������˷�����
				 OutputStream out =socket.getOutputStream();//���������
				out.write("GEC\r\n".getBytes());//������������
				//flag=true;
				new Thread(new senddata()).start();//��������ͨ�������߳�
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	//�����߳�
	public void btn11(View view){
		//���Ĳ� �����߳�
		if(flag==false) {
    		flag=true;
    		new Thread(new ClientThread()).start();
    	}
    	else {
    		Toast.makeText(MainActivity.this, "���Ѿ���������", 1).show();
    	}
	}
	
	//ֹͣת��
	public void btn2(View view){
		//������ֹͣ��ʽ��ֹͣѭ������ͨ�����飨ֹͣ�̣߳���
    	flag=false;
    	//ͬʱ������ֵ����
    	x34=0;
		data[3]=(byte)(x34>>8);  
		data[4]=(byte)(x34&0xff); 
		 //�ҿؼ�
		TextView tv=(TextView) findViewById(R.id.textView2);
		//������ֵ���ø��ؼ�
		tv.setText("����ֵ��"+x34+"");
		
	}
	
	//�ر���Ļ��ر�ͨ����
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
