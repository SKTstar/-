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

	

	//定义通信数组
	byte[] data=new byte[34];
	
	//定义flag，用于控制循环发送通信数组。
	boolean flag=false;
	
	//定义socket
	Socket socket;
	
	//定义x34，用于临时存放油门值。
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
	 * 给通信数组添加初始数据
	 */
	public void initdata(){
		data[0]=(byte)0xAA;  	//协议固定值
		data[1]=(byte)0xC0;		//协议固定值
		data[2]=(byte)0x1C;		//协议固定值
		//用于控制上下方向（油门值）
		data[3]=(byte)0x00;
		data[4]=(byte)0x00;
		//用于控制左旋右旋（航向值）
		data[5]=(byte)(1500>>8);
		data[6]=(byte)(1500&0xff);
		//用于控制左右方向（横滚值）
		data[7]=(byte)(1500>>8);
		data[8]=(byte)(1500&0xff);
		//控制前后方向（俯仰值）
		data[9]=(byte)(1500>>8);
		data[10]=(byte)(1500&0xff);
		
		data[31]=(byte)0x1C;	//协议固定值
		data[32]=(byte)0x0D;	//协议固定值
		data[33]=(byte)0x0A;	//协议固定值
		
	}
	//控制油门
//	public void btnadd(View view){
//		//用于控制上下方向（油门值）
//		data[3]=(byte)(300>>8);  //把100拆为高八位
//		data[4]=(byte)(300&0xff);  //把100拆为低八位
//		new Thread(new senddata()).start();
//	}
	
	public void initseekbar1(){
		//找控件
		SeekBar sb1=(SeekBar) findViewById(R.id.seekBar1);
		//设置最大值
		sb1.setMax(1000);
		//调用方法，获取当前的值
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
				data[3]=(byte)(i>>8);  //把获取的值拆为高八位
				data[4]=(byte)(i&0xff);  //把获取的值拆为低八位
				//new Thread(new senddata()).start();
				 //找控件
				TextView tv=(TextView) findViewById(R.id.textView2);
				//把油门值设置给控件
				tv.setText("油门值："+i+"");
				
			}
		});
	}
	
	public void initseekbar2(){
		//找控件
		SeekBar sb2=(SeekBar) findViewById(R.id.seekBar2);
		//设置最大值
		sb2.setMax(3000);
		//设置默认值
		sb2.setProgress(1500);
		//调用方法，获取当前的值
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
				data[5]=(byte)(i>>8);  //把获取的值拆为高八位
				data[6]=(byte)(i&0xff);  //把获取的值拆为低八位
				//new Thread(new senddata()).start();
				 //找控件
				TextView tv=(TextView) findViewById(R.id.textView3);
				//把航线值设置给控件
				tv.setText("航线值："+i+"");
				
			}
		});
	}
	
	
	
	
	public void initseekbar3(){
		//找控件
		SeekBar sb3=(SeekBar) findViewById(R.id.seekBar3);
		//设置最大值
		sb3.setMax(3000);
		//设置默认值
		sb3.setProgress(1500);
		//调用方法，获取当前的值
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
				data[7]=(byte)(i>>8);  //把获取的值拆为高八位
				data[8]=(byte)(i&0xff);  //把获取的值拆为低八位
				//new Thread(new senddata()).start();
				 //找控件
				TextView tv=(TextView) findViewById(R.id.textView4);
				//把横滚值设置给控件
				tv.setText("横滚值："+i+"");
				
			}
		});
	}
	public void initseekbar4(){
		//找控件
		SeekBar sb4=(SeekBar) findViewById(R.id.seekBar4);
		//设置最大值
		sb4.setMax(3000);
		//设置默认值
		sb4.setProgress(1500);
		//调用方法，获取当前的值
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
				data[9]=(byte)(i>>8);  //把获取的值拆为高八位
				data[10]=(byte)(i&0xff);  //把获取的值拆为低八位
				//new Thread(new senddata()).start();
				 //找控件
				TextView tv=(TextView) findViewById(R.id.textView5);
				//把俯仰值设置给控件
				tv.setText("俯仰值："+i+"");
				
			}
		});
	}
	
	
	
	/**
	 * 本线程类作用：发送通信数组给无人机
	 */
	public class senddata implements Runnable{

		@Override
		public void run() {
			OutputStream out;
			try {
				out =socket.getOutputStream();	//调用输出流
				while(flag){
					out.write(data); //发送通信数组
					Thread.sleep(5); //每五毫秒发送一次
				}
			} catch (IOException e) {	
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
	}

	/*
	 * 第二步创建线程
	 */
	public class ClientThread implements Runnable{

		@Override
		public void run() {
			//第三步在线程内通行
			
			try {
				//3.1 调用socket类连接访问的IP地址和端口号
				 socket=new Socket("192.168.4.1",333);
				//3.2用输入输出流给服务端发数据
				 OutputStream out =socket.getOutputStream();//调用输出流
				out.write("GEC\r\n".getBytes());//发送连接数据
				//flag=true;
				new Thread(new senddata()).start();//启动发送通信数组线程
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	//启动线程
	public void btn11(View view){
		//第四步 启动线程
		if(flag==false) {
    		flag=true;
    		new Thread(new ClientThread()).start();
    	}
    	else {
    		Toast.makeText(MainActivity.this, "你已经启动过了", 1).show();
    	}
	}
	
	//停止转动
	public void btn2(View view){
		//第三种停止方式：停止循环发送通信数组（停止线程）。
    	flag=false;
    	//同时把油门值清零
    	x34=0;
		data[3]=(byte)(x34>>8);  
		data[4]=(byte)(x34&0xff); 
		 //找控件
		TextView tv=(TextView) findViewById(R.id.textView2);
		//把油门值设置给控件
		tv.setText("油门值："+x34+"");
		
	}
	
	//关闭屏幕则关闭通行信
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
