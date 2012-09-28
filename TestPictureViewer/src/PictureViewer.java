/**
 * 
 */

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import loaders.SamDirLocalLoader;

import brahma.host.GUIPlugin;
import brahma.host.ILoader;

/**
 * @author risdenkj
 *
 */
public class PictureViewer extends GUIPlugin implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ILoader loader;
	private BufferedImage image;

	public PictureViewer() {
		super();
		this.loader = new SamDirLocalLoader();
		this.image = loader.getImage();
		addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.image = this.loader.getImage();
		this.repaint();
	}
	
	public void paint(Graphics g) {
		int newImageHeight = this.image.getHeight();
		int newImageWidth = this.image.getWidth();
		if (this.image.getHeight() >= this.image.getWidth() && this.image.getHeight() > getHeight()) {
			newImageHeight = getHeight();
			newImageWidth = Math.round((getHeight()/((float)this.image.getHeight()))*this.image.getWidth());
		} else if(this.image.getHeight() < this.image.getWidth() && image.getWidth() > getWidth()) {
			newImageHeight = Math.round((getWidth()/((float)this.image.getWidth()))*this.image.getHeight());
			newImageWidth = getWidth();
		}
		g.drawImage(this.image, getWidth()/2-newImageWidth/2, getHeight()/2-newImageHeight/2, newImageWidth, newImageHeight, null);
	}

	@Override
	public Boolean start() {
		JFrame frame = new JFrame("Display image");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel panel = new PictureViewer();
		frame.setSize(500, 500);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		return true;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	PictureViewer pv = new PictureViewer();
        		pv.start();
            }
        });
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
