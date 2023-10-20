package com.odehbros.flutter_file_downloader.core;

import android.app.Activity;
import java.util.Map;

public class DownloadTaskBuilder {
    String url, name, downloadDestination;
    String notifications = "progressOnly";
    DownloadCallbacks callbacks;
    Map<String, String> headers;
    final Activity activity;
    private DownloadTask task;

    public DownloadTaskBuilder(final Activity activity) {
        this.activity = activity;
    }

    public DownloadTaskBuilder setUrl(final String url) {
        this.url = url;
        return this;
    }

    public DownloadTaskBuilder setHeaders(final Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public DownloadTaskBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public DownloadTaskBuilder setShowNotifications(String notifications) {
        if (notifications != null && !notifications.isEmpty())
            this.notifications = notifications;
        return this;
    }

    public DownloadTaskBuilder setDownloadDestination(final String downloadDestination) {
        this.downloadDestination = downloadDestination;
        return this;
    }

    public DownloadTaskBuilder setCallbacks(final DownloadCallbacks callbacks) {
        this.callbacks = callbacks;
        return this;
    }

    public DownloadTask build() {
        if (task == null)
            task = new DownloadTask(activity, url, name, notifications, downloadDestination, callbacks, headers);
        try {
            return getDownloadTask();
        } catch (Exception e) {
            return task;
        }
    }

    public DownloadTask getDownloadTask() throws Exception {
        if (task == null)
            throw new Exception("build method is not called, you should call \"downloadTaskBuilder.build()\" first");
        return task;
    }
}
