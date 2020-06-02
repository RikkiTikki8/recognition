package com.example.recognition.model;

/*
public class Recognition {
    private IModelAdapter mModel;
    private IViewAdapter mView;
    private ISaverAdapter mSaver;

    private Data[] mLastData;
    private String mLastImageUri;
    private int mLastModelCode;
    private String[] mModelArray;
    private List<Request> mRequests;
    private Options mOptions;

    private boolean mIsRequestDone;

    public Recognition(IModelAdapter model, IViewAdapter view, ISaverAdapter saver) {
        mModel = model;
        mView = view;
        mSaver = saver;
        mLastData = null;
        mLastModelCode = -1;
        mLastImageUri = null;
        mModelArray = mModel.getModels();
        mModel.getData().addListener(new Action<Data>() {
            @Override
            public void onEventFired(Data... args) {
                getRequest(args);
            }
        });
        mRequests = Arrays.asList(mSaver.getFavorites());
        mOptions = mSaver.getOptions();
        mIsRequestDone = true;
    }
    private void getRequest(Data[] data) {
        if (null != data) {
            mLastData = data;
            if (!mIsRequestDone) {
                mView.getRequestEvent().fire(data);
            }
        } else {
            mView.getInfoEvent().fire("Request Failed: Check Internet connection");
        }
        mIsRequestDone = true;

    }
    public String[] getModels() {
        return mModelArray;
    }
    public void startRequest(String imageUri, int modelCode) {
        if (modelCode >= 0 && modelCode < mModelArray.length) {
            if (mLastImageUri == imageUri && mLastModelCode == modelCode && mIsRequestDone) {
                getRequest(mLastData);
            } else {
                mLastImageUri = imageUri;
                mLastModelCode = modelCode;
                mModel.sendRequest(imageUri, modelCode);
                mIsRequestDone = false;
            }
        } else {
            mView.getInfoEvent().fire("Request Error: incorrect request model");
        }
    }
    public void stopRequest() {
        mIsRequestDone = true;
    }
    public Data[] getLastRequest() {
        return mLastData;
    }
    public void addToFavorites() {
        boolean isExist = false;
        final int length = mRequests.size();
        for (Request request : mRequests) {
            if (request.getImage() == mLastImageUri
                    && request.getRequestData() == mLastData
                    && request.getModel() == mModelArray[mLastModelCode]) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            mRequests.add(new Request(mLastImageUri, mLastData, mModelArray[mLastModelCode]));
        }
    }
    public void removeFromFavorites(int index) {
        mRequests.remove(index);
    }
    public List<String> getFavoritesImages() {
        List<String> imagesUri = new ArrayList<>();
        for (Request request : mRequests) {
            imagesUri.add(request.getImage());
        }
        return  imagesUri;
    }
    public Request getFavoriteData(int index) {
        return mRequests.get(index);
    }
    public Options getOptions() {
        return mOptions;
    }
    public void setOptions(Options options) {
        mOptions = options;
    }
    public void Save() {
        mSaver.setFavorites((Request[]) mRequests.toArray());
        mSaver.setOptions(mOptions);
    }
}
*/