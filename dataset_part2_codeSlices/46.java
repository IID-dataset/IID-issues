Triggering condition: no triggering condition description
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------

public LoadData<InputStream> buildLoadData(@NonNull String model, int width, int height, @NonNull Options options) {
return new LoadData<>(new ObjectKey(model), new OkHttpStreamFetcher(client, new GlideUrl(model)));
public class OkHttpStreamFetcher implements DataFetcher<InputStream> {
/**
The begin of a functional module: image loading
**/
public void loadData(
client.newCall(request).enqueue(
new com.squareup.okhttp.Callback() {
public void onResponse(Response response) throws IOException {
responseBody = response.body();
if (response.isSuccessful()) {
long contentLength = responseBody.contentLength();
stream =ContentLengthInputStream.obtain(responseBody.byteStream(), contentLength);
callback.onDataReady(stream);

/**
The end of the functional module: image loading
**/

Error description:line 13-21, lack of necessary functional modules







