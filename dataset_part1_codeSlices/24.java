Triggering condition: displaying a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onEditorFragmentInitialized() {
fillContentEditorFields();
private void fillContentEditorFields() {
String action = getIntent().getAction();
if (Intent.ACTION_SEND.equals(action) || Intent.ACTION_SEND_MULTIPLE.equals(action)) {
setPostContentFromShareAction();
protected void setPostContentFromShareAction() {
ArrayList<Uri> sharedUris;
if (Intent.ACTION_SEND_MULTIPLE.equals(action)) {
sharedUris = intent.getParcelableArrayListExtra((Intent.EXTRA_STREAM));
if (sharedUris != null) {
for (Uri uri : sharedUris) {
addMedia(uri);//buggy code
public boolean addMedia(Uri mediaUri) {
if (mediaUri != null && !MediaUtils.isInMediaStore(mediaUri) && !mediaUri.toString().startsWith("/")&& !mediaUri.toString().startsWith("file://") ) {
mediaUri = MediaUtils.downloadExternalMedia(this, mediaUri);
/**
The begin of a functional module: downloading image resources
These code should be executed in a background thread
**/
public static Uri downloadExternalMedia(Context context, Uri imageUri) {
String mimeType = context.getContentResolver().getType(imageUri);
File cacheDir = getDiskCacheDir(context);
InputStream input;
if (imageUri.toString().startsWith("content://")) {
input = context.getContentResolver().openInputStream(imageUri);
String fileName = getFilenameFromURI(context, imageUri);
if (TextUtils.isEmpty(fileName)) {
fileName = generateTimeStampedFileName(mimeType);
File f = getUniqueCacheFileForName(fileName, cacheDir, mimeType);
private static File getUniqueCacheFileForName(String fileName, File cacheDir, String mimeType) {
File file = new File(cacheDir, fileName);
while (file.exists()) {
Matcher matcher = FILE_EXISTS_PATTERN.matcher(fileName);
if (matcher.matches()) {
String baseFileName = matcher.group(1);
String existingDuplicationNumber = matcher.group(3);
String fileType = StringUtils.notNullStr(matcher.group(4));
if (existingDuplicationNumber == null) {
fileName = baseFileName + "-1" + fileType;
file = new File(cacheDir, fileName);
return file;
/**
The end of the functional module: downloading image resources
**/
OutputStream output = new FileOutputStream(f);
byte data[] = new byte[1024];
int count;
while ((count = input.read(data)) != -1) {
output.write(data, 0, count);//The functional module of image disk caching

Error description:line 26-47, inappropriate code implementation