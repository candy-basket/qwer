package com.candybasket.util.volley;

import java.io.File;
import java.nio.ByteBuffer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.ImageLoader.ImageCache;

public class DiskBitmapCache extends DiskBasedCache implements ImageCache {
	 
	private static String TAG = DiskBitmapCache.class.getSimpleName();
	
	private File cacheDir;
	
    public DiskBitmapCache(File rootDirectory, int maxCacheSizeInBytes) {
        super(rootDirectory, maxCacheSizeInBytes);
    }

    public DiskBitmapCache(File cacheDir) {
        super(cacheDir);
        this.cacheDir = cacheDir;
    }

    private File getCacheDir(){
    	return cacheDir;
    }
    
    public Bitmap getBitmap(String url) {
        final String volleyFileName = getFilenameForKey(url);
        if (getCacheDir().listFiles() != null)
            for (File file : getCacheDir().listFiles()) {
                if (file.getName().equals(volleyFileName)){
                    return BitmapFactory.decodeFile(file.getName());
                }
            }
        return null;
    }

    public void putBitmap(String url, Bitmap bitmap) {
        final Entry entry = new Entry();

        ByteBuffer buffer = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(buffer);
        entry.data = buffer.array();

        entry.etag = null;
        entry.softTtl = Long.MAX_VALUE;
        entry.ttl = Long.MAX_VALUE;
        
        put(url, entry);
    }

    // Volley creates a filename for the url with the following function, so we'll use the same function
    // for translating the url back to said filename
    private String getFilenameForKey(String key) {
        int firstHalfLength = key.length() / 2;
        String localFilename = String.valueOf(key.substring(0, firstHalfLength).hashCode());
        localFilename += String.valueOf(key.substring(firstHalfLength).hashCode());
        return localFilename;
    }
}

