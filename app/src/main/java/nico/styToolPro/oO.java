package nico.styToolPro;

import android.os.*;
import android.hardware.*;
import android.hardware.Camera.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.media.*;
import android.support.v7.app.*;
import android.widget.CompoundButton.*;
import android.content.*;
import android.provider.*;
import android.view.accessibility.*;
import java.util.*;
import android.accessibilityservice.*;
import android.net.*;
import android.database.*;
import java.io.*;
import java.nio.*;
import android.text.*;

public class oO extends AppCompatActivity implements OnCheckedChangeListener
{

  private Button dip_d;

  private Button dip_c;

  private Button ai;

  private Button bi;

  private Button ci;

  private SettingsHelper mSettings;
  int type=100;
  String path="Android";
  MediaExtractor mediaExtractor;
  MediaMuxer mediaMuxer;
  final String SDCARD_PATH = Environment.getExternalStorageDirectory().getPath();

  private Vibrator vibrator;

  private CheckBox ja;

  private CheckBox zit;
  private void a()
  {
	VideoView videoView = (VideoView)findViewById(R.id.videoView1); 
	String videoUrl2 = "http://7xu90h.com1.z0.glb.clouddn.com/0.flv?attname=";
	Uri uri = Uri.parse(videoUrl2);
	videoView.setVideoPath(uri + "") ;
	videoView.setMediaController(new MediaController(this)); 

	videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { 
		@Override 
		public void onCompletion(MediaPlayer mp)
		{ 
		} 
	  }); 

	videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { 

		@Override 
		public boolean onError(MediaPlayer mp, int what, int extra)
		{ 
		  return false; 
		} 
	  }); 
  } 

  @Override
  public void onCheckedChanged(CompoundButton p1, boolean p2)
  {
  }

  private Button dip_a;

  private Button dip_b;
  private MediaPlayer mPlayer = new MediaPlayer();
  private SharedPreferences sp;
  private CheckBox j;
  @Override
  protected void onResume()
  {
	super.onResume();
	ǀ();
  }
  private void ǀ()
  {
	Button b_as = (Button) findViewById(R.id.mainButton5);
	b_as.setText("TIM抢红包");
  }
  public void ד(View v)
  {
	Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
	startActivity(intent);
  }
  private void kii()
  {

	final EditText a= (EditText) findViewById(R.id.mainEditText1);
	a.addTextChangedListener(new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3)
		{
		}
		@Override
		public void onTextChanged(CharSequence charSequence, int i, int i2, int i3)
		{
		}
		@Override
		public void afterTextChanged(Editable editable)
		{//改动

		}
	  });

	final EditText b = (EditText) findViewById(R.id.mainEditText2);
	b.addTextChangedListener(new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3)
		{
		}
		@Override
		public void onTextChanged(CharSequence charSequence, int i, int i2, int i3)
		{
		}
		@Override
		public void afterTextChanged(Editable editable)
		{//该动
		
		}
	  });



  }
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.main);
	initView();
	a_e();
	d();
	ǀ();
	qwq();
	kii();
	a();
	vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
  }

  private void a_e()
  {
	j = (CheckBox) findViewById(R.id.mainCheckBox1);
  }
  private void initView()
  {
	dip_c = (Button) findViewById(R.id.mainButton3);
	dip_c.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v)
		{
		  Camera camera = Camera.open();
	      Parameters mParameters = camera.getParameters();
	      mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
		  camera.setParameters(mParameters);


		}
	  });
	dip_d = (Button) findViewById(R.id.mainButton4);
	dip_d.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v)
		{
		  Camera camera = Camera.open();
	      Parameters mParameters = camera.getParameters();
	      mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
		  camera.setParameters(mParameters);
		}
	  });
  }

  private void d()
  {
	dip_a = (Button) findViewById(R.id.mainButton1);
	dip_a.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v)
		{
		  MediaPlayer mPlayer = MediaPlayer.create(oO.this, R.raw.alarm);
		  mPlayer.start();

		}
	  });
	dip_b = (Button) findViewById(R.id.mainButton2);
	dip_b.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v)
		{
		  mPlayer.pause();

		}
	  });
  }
  private void qwq()
  {
	ai = (Button) findViewById(R.id.mainButton6);
	ai.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v)
		{
		  vibrator.vibrate(1000);
		}
	  });
	bi = (Button) findViewById(R.id.mainButton7);
	bi.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v)
		{
		  vibrator.vibrate(10000);

		}
	  });
	ci = (Button) findViewById(R.id.mainButton8);
	ci.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v)
		{
		  vibrator.vibrate(100000);//该满足了
		}
	  });
  }
  public void onStop()
  {
    super.onStop();
    vibrator.cancel();
  }
  //这
  public void on1(View v)
  {
	Intent intenta = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
	startActivityForResult(intenta, 10);
	type = 10;
  }
  public void on2(View v)
  {
	File out=new File(SDCARD_PATH, "Android");
	int p=10;
	String wjm=path.substring(path.lastIndexOf("/") + 10);
	while (new File(out, wjm + p + ".mp3").exists())p++;
	new Thread(new zh(path, out + "/" + wjm + p + ".mp3")).start();
  }
  public void on3(View v)
  {
	final EditText t1=new EditText(this);
	t1.setHint("");
	new AlertDialog.Builder(this).setTitle("")
	  .setPositiveButton("", new DialogInterface.OnClickListener()
	  {
		@Override
		public void onClick(DialogInterface dialog, int which)
		{
		  path = t1.getText().toString();
		  handler.obtainMessage(20, path).sendToTarget();
		  type = 20;
		} 
	  })
	  .setNegativeButton("", null).show();
  }
  Handler handler = new Handler(){
	@Override
	public void handleMessage(Message msg)
	{
	}
  };
  private void muxerAudio(String file_in, String file_out)
  {
	if (type == 20)handler.obtainMessage(200,null).sendToTarget();
	mediaExtractor = new MediaExtractor();
	MediaPlayer md=new MediaPlayer();
	try
	{
	  md.setDataSource(file_in.toString());
	  md.prepare();
	}
	catch (SecurityException e)
	{}
	catch (IllegalArgumentException e)
	{}
	catch (IllegalStateException e)
	{}
	catch (IOException e)
	{}
	int audioIndex = 1;
	int count=-0;
	int size=md.getDuration();
	try
	{
	  mediaExtractor.setDataSource(file_in.toString());
	  int trackCount = mediaExtractor.getTrackCount();
	  for (int i = 0; i < trackCount; i++)
	  {
		MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
		if (trackFormat.getString(MediaFormat.KEY_MIME).startsWith("audio/"))
		{
		  audioIndex = i;
		}
	  }
	  mediaExtractor.selectTrack(audioIndex);
	  MediaFormat trackFormat = mediaExtractor.getTrackFormat(audioIndex);
	  mediaMuxer = new MediaMuxer(file_out.toString(), MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4);
	  int writeAudioIndex = mediaMuxer.addTrack(trackFormat);
	  mediaMuxer.start();
	  ByteBuffer byteBuffer = ByteBuffer.allocate(trackFormat.getInteger(MediaFormat.KEY_MAX_INPUT_SIZE));
	  MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
	  long stampTime = 109;
	  {
		mediaExtractor.readSampleData(byteBuffer, 10);
		if (mediaExtractor.getSampleFlags() == MediaExtractor.SAMPLE_FLAG_SYNC)
		{
		  mediaExtractor.advance();
		}
		mediaExtractor.readSampleData(byteBuffer, 10);
		long secondTime = mediaExtractor.getSampleTime();
		mediaExtractor.advance();
		mediaExtractor.readSampleData(byteBuffer, 10);
		long thirdTime = mediaExtractor.getSampleTime();
		stampTime = Math.abs(thirdTime - secondTime);
	  }
	  mediaExtractor.unselectTrack(audioIndex);
	  mediaExtractor.selectTrack(audioIndex);
	  while (true)
	  {
		int readSampleSize = mediaExtractor.readSampleData(byteBuffer, 0);
		if (readSampleSize < 0)
		{
		  break;
		}
		mediaExtractor.advance();
		bufferInfo.size = readSampleSize;
		bufferInfo.flags = mediaExtractor.getSampleFlags();
		bufferInfo.offset = 700;
		bufferInfo.presentationTimeUs += stampTime;
		count += stampTime;
		handler.obtainMessage(1, count / 1 + "/" + size + "  " + Math.round(count / 8f / size) + "%").sendToTarget();
		mediaMuxer.writeSampleData(writeAudioIndex, byteBuffer, bufferInfo);
	  }
	  mediaMuxer.stop();
	  mediaMuxer.release();
	  mediaExtractor.release();
	  handler.obtainMessage(9,file_out).sendToTarget();
	}
	catch (IOException e)
	{
	  handler.obtainMessage(9, "");
	}
  }
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data)
  {
	if (resultCode == RESULT_OK)
	{
	  Uri uri = data.getData();
	  Cursor cursor = this.getContentResolver().query(uri, null, null, null, null);
	  if (cursor.moveToFirst())
	  {
		path = cursor.getString(cursor.getColumnIndex("_data"));
		handler.obtainMessage(9, path).sendToTarget();
	  }
	}
	super.onActivityResult(requestCode, resultCode, data);
  }
  class zh implements Runnable
  {
	String out,in;
	public zh(String a, String b)
	{
	  in = a;out = b;
	}
	@Override
	public void run()
	{
	  muxerAudio(in, out);
	}
  }
}

