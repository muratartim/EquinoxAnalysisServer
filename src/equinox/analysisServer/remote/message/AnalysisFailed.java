/*
 * Copyright 2018 Murat Artim (muratartim@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package equinox.analysisServer.remote.message;

/**
 * Class for analysis failed message.
 *
 * @author Murat Artim
 * @date 31 Mar 2017
 * @time 10:36:15
 *
 */
public final class AnalysisFailed extends AnalysisMessage {

	/** Serial ID. */
	private static final long serialVersionUID = 1L;

	/** Thrown exception message. */
	private String exceptionMessage_;

	/** Analysis output file download URL. */
	private String downloadUrl_ = null;

	/**
	 * No argument constructor for serialization.
	 */
	public AnalysisFailed() {
	}

	/**
	 * Sets thrown exception to this message.
	 *
	 * @param exception
	 *            Thrown exception of the analysis.
	 */
	public void setException(Exception exception) {
		exceptionMessage_ = exception.getMessage() + "\n";
		for (StackTraceElement ste : exception.getStackTrace()) {
			exceptionMessage_ += ste.toString() + "\n";
		}
	}

	/**
	 * Sets analysis output file download URL.
	 *
	 * @param downloadUrl
	 *            Analysis output file download URL or <code>null</code> should be given if no output file was uploaded or produced.
	 */
	public void setDownloadUrl(String downloadUrl) {
		downloadUrl_ = downloadUrl;
	}

	/**
	 * Returns the thrown exception message of the analysis. This message also contains the stack trace.
	 *
	 * @return The thrown exception message of the analysis.
	 */
	public String getExceptionMessage() {
		return exceptionMessage_;
	}

	/**
	 * Returns analysis output file download URL or <code>null</code> if no output file was uploaded or produced.
	 *
	 * @return Analysis output file download URL or <code>null</code> if no output file was uploaded or produced.
	 */
	public String getDownloadUrl() {
		return downloadUrl_;
	}
}
