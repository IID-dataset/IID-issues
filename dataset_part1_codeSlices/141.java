Triggering condition: handling a large image
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
if (resultCode == RESULT_OK) {
if (requestCode == REQUEST_SEND_IMAGE || requestCode == REQUEST_SEND_FILE || requestCode == REQUEST_SEND_AUDIO) {
Uri uri = resultIntent.getData() ;
boolean deleteAudioFile = (requestCode == REQUEST_SEND_AUDIO);
handleSendDelete(uri, null, deleteAudioFile, false);
private void handleSendDelete( Uri contentUri, String mimeType, boolean delete ) {
FileInfo info = SystemServices.getFileInfoFromURI(this, contentUri);
String sessionId = getCurrentSessionId();
public static Uri importContent(String sessionId, String sourcePath) throws IOException {
File sourceFile = new File(sourcePath);
String targetPath = "/" + sessionId + "/upload/" + sourceFile.getName();
targetPath = createUniqueFilename(targetPath);
copyToVfs( sourcePath, targetPath );
return vfsUri(targetPath);
Uri vfsUri = ChatFileStore.importContent(sessionId, info.path);
//error position      lack a functional module of image resizing to resize the image in vfsUri
boolean sent = handleSend(vfsUri, (mimeType==null) ? info.type : mimeType);

Error description:line 21，23, inappropriate code implementation
