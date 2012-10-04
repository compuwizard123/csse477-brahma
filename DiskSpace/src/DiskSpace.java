/**
 * 
 */

import java.io.File;

import brahma.host.CLIPlugin;

/**
 * @author risdenkj
 *
 */
public class DiskSpace extends CLIPlugin {
	/**
	 * 
	 */
	public DiskSpace() {
		super();
	}
	
	private void getDiskSpace() {
		for(File i: File.listRoots()) {
			System.out.println("For " + i);
			System.out.println("\tTotal Space: " + i.getTotalSpace() + "bytes");
			System.out.println("\tFree Space: " + i.getFreeSpace() + "bytes");
			System.out.println("\tUsable Space: " + i.getUsableSpace() + "bytes");
		}
	}
	
	@Override
	public Boolean start() {
		this.getDiskSpace();
		return true;
	}
	
	public static void main(String[] args) {
		try {
			DiskSpace ds = new DiskSpace();
			ds.start();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
