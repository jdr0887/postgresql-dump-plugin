package org.renci.maven.plugins;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "dump", defaultPhase = LifecyclePhase.PROCESS_RESOURCES, requiresProject = true)
public final class DumpMojo extends AbstractMojo {

	@Parameter(defaultValue = "${project}", readonly = true)
	private MavenProject project;

	@Override
	public void execute() throws MojoExecutionException {
		File srcDir = new File(project.getBasedir(), "src");
		File mainDir = new File(srcDir, "main");
		File dumpDir = new File(mainDir, "dump");
		File artifact = new File(dumpDir, "database.dump");
		this.project.getArtifact().setFile(artifact);
	}

	public MavenProject getProject() {
		return project;
	}

	public void setProject(MavenProject project) {
		this.project = project;
	}

}
