Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onActivityResult(int requestCode, int resultCode, Intent data) {
if (requestCode == SELECT_PHOTO) {
if (resultCode == Activity.RESULT_OK) {
/**
The begin of a functional module: image decoding
**/
final Uri imageUri = data.getData();
final InputStream imageStream = getActivity().getContentResolver().openInputStream(imageUri);
final Bitmap bitmap = BitmapFactory.decodeStream(imageStream);//buggy code
/**
The begin of a functional module: image decoding
**/
String response = QRCodeUtils.decodeFromBitmap(bitmap);
public static String decodeFromBitmap(Bitmap bitmap) throws DataFormatException, IOException, FormatException, ChecksumException, NotFoundException {
Reader reader = new QRCodeMultiReader();
Result result = reader.decode(getBinaryBitmap(bitmap), tmpHintsMap);
return CompressionUtils.decompress(result.getText());
public static String decompress(String compressedString) throws IOException, DataFormatException {
byte[] output = Base64.decodeBase64(compressedString);
Inflater inflater = new Inflater();
inflater.setInput(output);
ByteArrayOutputStream outputStream = new ByteArrayOutputStream(output.length);
byte[] buffer = new byte[1024];
while (!inflater.finished()) {
int count = inflater.inflate(buffer);
outputStream.write(buffer, 0, count);
outputStream.close();
byte[] result = outputStream.toByteArray();
String outputString = new String(result, "UTF-8");
return outputString;

Error description:line 14, inappropriate code implementation  