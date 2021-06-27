Triggering condition: no triggering condition description
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void initializeEditorFragment() {
if (mEditorFragment instanceof AztecEditorFragment) {
AztecEditorFragment aztecEditorFragment = (AztecEditorFragment)mEditorFragment;
aztecEditorFragment.setEditorBetaClickListener(EditPostActivity.this);
aztecEditorFragment.setEditorImageSettingsListener(EditPostActivity.this);
Drawable loadingImagePlaceholder = getResources().getDrawable(org.wordpress.android.editor.R.drawable.ic_gridicons_image);
loadingImagePlaceholder.setBounds(0, 0,AztecEditorFragment.DEFAULT_MEDIA_PLACEHOLDER_DIMENSION_DP,AztecEditorFragment.DEFAULT_MEDIA_PLACEHOLDER_DIMENSION_DP);//The functional module of image displaying     buggy code
aztecEditorFragment.setAztecImageLoader(new AztecImageLoader(getBaseContext(), loadingImagePlaceholder));
aztecEditorFragment.setLoadingImagePlaceholder(loadingImagePlaceholder);

Error description:line 9, inappropriate code implementation