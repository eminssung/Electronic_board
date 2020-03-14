package ssireum.Game;

<<<<<<< HEAD

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer; 

public class AdPanel extends JPanel { 
	private EmbeddedMediaPlayerComponent component; 
	private EmbeddedMediaPlayer player; 
	private int file_index = 0; 
	private String[] av_list; 

	public AdPanel() { 
		boolean found = new NativeDiscovery().discover(); 
		System.out.println(found); 
		//		System.out.println(LibVlc.INSTANCE.libvlc_get_version()); 
		component = new EmbeddedMediaPlayerComponent(); 
		player = component.mediaPlayer(); 
		setLayout(new BorderLayout()); 
		setAlignmentX(Component.LEFT_ALIGNMENT); 
		setPreferredSize(new Dimension(500, 200)); 
		setVisible(true); 
		add(component, BorderLayout.CENTER); 

		player.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() { 
			@Override 
			public void finished(MediaPlayer mediaPlayer) { 
				endAV();
			} 
		});

	} 

	public void setAV(final String fnames[]) { 
		av_list = fnames; 
		file_index = 0; 
		runAV(); 
	}

	private void runAV() { 
		new Thread(new Runnable() { 
			@Override 
			public void run() { 
				player.media().play(av_list[file_index]);
			} 
		}).start(); 
	}

	private void endAV() {
		component.release(); 
		remove(component); 
		component = new EmbeddedMediaPlayerComponent(); 
		player = component.mediaPlayer();
		add(component, BorderLayout.CENTER); 
		player.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() { 
			@Override 
			public void finished(MediaPlayer mediaPlayer) { 
				endAV();
			} 
		});
		file_index = ++ file_index % av_list.length; runAV();
	}
=======
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdPanel extends JPanel {

	public AdPanel() {
		this.setBackground(Color.gray);
		this.setBorder(BorderFactory.createEmptyBorder(200,0,0,0));
		this.add(new JLabel("±¤°í"));
	}

>>>>>>> db7470642cb2c3f4e624c3d4b781c41f064fd66f
	
}
