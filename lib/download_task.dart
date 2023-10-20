part of 'flutter_file_downloader.dart';

///The download task model to store some unique vars
class _DownloadTask {
  late final String id;
  late final int key;
  final String url;
  final String? name;
  final NotificationType notificationType;
  final DownloadDestinations downloadDestination;
  final DownloadCallbacks callbacks;
  final Map<String, String>? headers;

  final Completer _completer;

  _DownloadTask({
    required this.url,
    required this.callbacks,
    this.name,
    this.notificationType = NotificationType.progressOnly,
    this.downloadDestination = DownloadDestinations.publicDownloads,
    this.headers,
  }) : //key = DateTime.now().millisecondsSinceEpoch.toString(),
        _completer = Completer();

  bool get isDownloaded => _completer.isCompleted;

  //To download until this specific task is fully downloaded
  Future waitDownload() => _completer.future;

  //To notify observers that this task is fully downloaded
  void notifyDownloaded() => _completer.complete();
}
