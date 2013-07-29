package org.codenarc.eclipse.popup.actions

import org.codenarc.eclipse.jobs.CheckCodeJob
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.jface.action.IAction
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IObjectActionDelegate
import org.eclipse.ui.IViewActionDelegate
import org.eclipse.ui.IViewPart
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate

/**
 * @author René Scheibe
 */
class CheckCodeAction implements IObjectActionDelegate, IViewActionDelegate, IWorkbenchWindowActionDelegate {

    private IStructuredSelection selection

    @Override
    void run(IAction action) {
        def job = new CheckCodeJob(selection)
        job.priority = Job.INTERACTIVE
        job.schedule()
    }

    @Override
    void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection)  {
            this.selection = selection
        }
    }

    @Override
    void setActivePart(IAction action, IWorkbenchPart targetPart) {}

    @Override
    public void init(IViewPart view) {
    }

    @Override
    public void init(IWorkbenchWindow window) {
    }
    
    @Override
    public void dispose() {
    }
}
