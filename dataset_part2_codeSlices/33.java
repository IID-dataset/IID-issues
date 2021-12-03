Triggering condition: display large images
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------



public static ImageSize getImageSizes(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(new File(filePath).getAbsolutePath(), options);
        int imageHeight = options.outHeight;//buggy code
        int imageWidth = options.outWidth;//buggy code
        return new ImageSize(imageHeight, imageWidth);
    }



Error description:line 13-14, inappropriate code implementation







